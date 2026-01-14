    Proyecto Diciembre SI

- Para instalar herramientas de ACL:
sudo apt update && sudo apt install acl -y

----------------------INICIO------------------------
1. Estructura de Carpetas y Grupos
----------------------------------------------------

- Creamos grupos editores, cámaras y promotores
groupadd editores
groupadd camaras
groupadd promotores

-----
- Creamos sus carpetas
mkdir -p /opt/compartido/recursos
mkdir -p /opt/compartido/videos_finales
mkdir -p /opt/compartido/estadísticas

--------
- Permisos de la carpeta raíz (/opt/compartido): Queremos que solo estos tres grupos entren.
Usaremos un grupo común o permisos detallados.

chgrp -R editores /opt/compartido


# Para que los otros grupos también entren, daremos permisos de ejecución a otros pero controlaremos dentro
chmod 771 /opt/compartido

-----------------------------------------------------
2. Gestión de Usuarios y Contraseñas
----------------------------------------------------

- 4 Usuarios por grupo con políticas de contraseña distintas
	· Editores/Cámaras: Sin home (-M) y cambio cada 15 días (chage -M 15).
	· Promotores: Con home y cambio cada 30 días (chage -M 30).

# Para un editor (repetir para editor1, editor2...)
useradd -M -g editores -s /bin/bash editor1
chage -M 15 editor1

# Para un cámara (repetir para camara1, camara2...)
useradd -M -g camaras -s /bin/bash camara1
chage -M 15 camara1

# Para un promotor (repetir para promotor1, promotor2...)
useradd -m -g promotores -s /bin/bash promotor1
chage -M 30 promotor1

-----------------------------------------------------
3. Permisos Específicos (ACLs)
----------------------------------------------------

La lógica de "quién puede tocar qué". Lo más profesional es usar ACLs (setfacl) para no liarnos con los dueños de grupo.
	1. Recursos: Cámaras escriben, editores leen.
setfacl -m g:camaras:rwx /opt/compartido/recursos
setfacl -m g:editores:rx /opt/compartido/recursos

	2. Videos_finales: Editores escriben, el resto lee.
setfacl -m g:editores:rwx /opt/compartido/videos_finales
setfacl -m o::r /opt/compartido/videos_finales

	3. Estadísticas: Solo promotores.
chmod 770 /opt/compartido/estadisticas
chgrp promotores /opt/compartido/estadísticas

-----------------------------------------------------
4. Script de Organización de Archivos
----------------------------------------------------

Este script debe ejecutarse cada 2 días para mover archivos a su sitio según su extensión.   

Archivo: /usr/local/bin/mover_extensiones.sh

````
#!/bin/bash
# Movemos según extensiones del PDF [cite: 29, 30, 31]

	# De cualquier sitio a Recursos (RAW, WAV)
find /opt/compartido -name "*.RAW" -o -name "*.WAV" -exec mv {} /opt/compartido/recursos/ \;

	# De cualquier sitio a Videos Finales (mp3, mp4, jpg, svg)
find /opt/compartido -name "*.mp3" -o -name "*.mp4" -o -name "*.jpg" -o -name "*.svg" -exec mv {} /opt/compartido/videos_finales/ \;

	# De cualquier sitio a Estadísticas (xls, doc, py, etc.)
find /opt/compartido -name "*.xls*" -o -name "*.doc*" -o -name "*.py" -o -name "*.csv" -o -name "*.json" -exec mv {} /opt/compartido/estadisticas/ \;
````


--------------------------------------------------------
5. Script de Clasificación por Mes y Tamaño
----------------------------------------------------

Este es el más complejo. Se ejecuta a diario y organiza lo que hay dentro de recursos.   

Archivo: /usr/local/bin/clasificar_recursos.sh

````
#!/bin/bash
RECURSOS_DIR="/opt/compartido/recursos"

# Buscamos archivos directamente en recursos (no en subcarpetas)
find "$RECURSOS_DIR" -maxdepth 1 -type f | while read -r archivo; do
    # Sacar mes en español (o inglés según sistema) y tamaño
    MES=$(date -r "$archivo" +%B)
    TAMANO_BYTES=$(stat -c%s "$archivo")
    
    # [cite_start]Lógica de carpetas de tamaño [cite: 34]
    if [ $TAMANO_BYTES -lt 10485760 ]; then RANGO="menos_10MB" # Opcional
    elif [ $TAMANO_BYTES -lt 104857600 ]; then RANGO="10-100MB"
    elif [ $TAMANO_BYTES -lt 1073741824 ]; then RANGO="100MB-1GB"
    else RANGO="mas_de_1GB"
    fi

    DESTINO="$RECURSOS_DIR/$MES/$RANGO"
    mkdir -p "$DESTINO"
    mv "$archivo" "$DESTINO"
done
````


--------------------------------------------------
6. Monitorización (Cron)
----------------------------------------------------

Para automatizar todo, editamos el cron (crontab -e)

# Cada 2 días: Script de extensiones
0 0 */2 * * /bin/bash /usr/local/bin/mover_extensiones.sh

# Diariamente: Script de clasificación
0 1 * * * /bin/bash /usr/local/bin/clasificar_recursos.sh

# Cada miércoles a las 9:00: Monitorizar editores [cite: 40]
````
#!/bin/bash
# [cite_start]Lista de editores según el PDF [cite: 13, 15]
EDITORES=("editor1" "editor2" "editor3" "editor4")

for usuario in "${EDITORES[@]}"
do
    # [cite_start]El PDF pide: pid, %mem, %cpu, user, command de los 5 procesos que más consumen [cite: 40]
    ps -u "$usuario" -o pid,%mem,%cpu,user,comm --sort=-%mem | head -n 6 > "/opt/compartido/$usuario"
done
````
(He puesto head -n 6 porque la primera línea es el encabezado (PID, %MEM...), y luego vienen los 5 procesos. Si pones head -n 5, solo verías 4 procesos.)