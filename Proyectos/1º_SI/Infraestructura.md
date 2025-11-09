# Implementación de Infraestructura TI para Nucleo

## Ejercicio 1
### Creación de usuarios

#### Parte A
Creación de grupos
```bash
sudo addgroup tecnicos
sudo addgroup desarrolladores
sudo addgroup administradores

```
#### Parte B
Creación de usuarios
```bash
sudo useradd -m -g tecnicos -d /home/tecnico1 tecnico1
sudo useradd -m -g tecnicos -d /home/tecnico2 tecnico2
sudo useradd -m -g tecnicos -d /home/tecnico3 tecnico3
sudo useradd -m -g tecnicos -d /home/tecnico4 tecnico4
sudo useradd -m -g tecnicos -d /home/tecnico5 tecnico5

sudo useradd -m -g desarrolladores -d /home/desarrollador1 desarrollador1
sudo useradd -m -g desarrolladores -d /home/desarrollador2 desarrollador2
sudo useradd -m -g desarrolladores -d /home/desarrollador3 desarrollador3
sudo useradd -m -g desarrolladores -d /home/desarrollador4 desarrollador4
sudo useradd -m -g desarrolladores -d /home/desarrollador5 desarrollador5

sudo useradd -m -g administradores -d /home/administrador1 administrador1
sudo useradd -m -g administradores -d /home/administrador2 administrador2
```


## Ejercicio 2
### Creación de estructura de archivos y carpetas

#### Parte A
```bash
cd opt
sudo mkdir compartido
cd compartido
mkdir src docs config recovery

```
#### Parte B
```bash
chgrp administradores /config
chmod 720 /config

```
#### Parte C
```bash
sudo addgroup Conjunto

usermod -aG Conjunto desarrollador1
usermod -aG Conjunto desarrollador2
usermod -aG Conjunto desarrollador3
usermod -aG Conjunto desarrollador4
usermod -aG Conjunto desarrollador5
usermod -aG Conjunto administrador1
usermod -aG Conjunto administrador2

chgrp Conjunto /src
chmod 764 /src

chgrp administradores /recovery
chmod 764 /recovery
```
#### Parte D
```bash
sudo addgroup ConjuntoCompleto

usermod -aG ConjuntoCompleto tecnico1
usermod -aG ConjuntoCompleto tecnico2
usermod -aG ConjuntoCompleto tecnico3
usermod -aG ConjuntoCompleto tecnico4
usermod -aG ConjuntoCompleto tecnico5
usermod -aG ConjuntoCompleto desarrollador1
usermod -aG ConjuntoCompleto desarrollador2
usermod -aG ConjuntoCompleto desarrollador3
usermod -aG ConjuntoCompleto desarrollador4
usermod -aG ConjuntoCompleto desarrollador5
usermod -aG ConjuntoCompleto administrador1
usermod -aG ConjuntoCompleto administrador2

chgrp ConjuntoCompleto /docs
chmod 764 /docs
```

## Ejercicio 3
### Automatización

#### Parte A
```bash
#!bin/bash
mv /opt/compartidos/*.py /opt/compartidos/src 2>/dev/null
mv /opt/compartidos/*.c /opt/compartidos/src 2>/dev/null
mv /opt/compartidos/*.cpp /opt/compartidos/src 2>/dev/null
mv /opt/compartidos/*.js /opt/compartidos/src 2>/dev/null
mv /opt/compartidos/*.sh /opt/compartidos/src 2>/dev/null

```
#### Parte B
```bash
#!bin/bash
mv /opt/compartidos/*.cfg /opt/compartidos/config 2>/dev/null

```
#### Parte C
```bash
#!bin/bash
mv /opt/compartidos/*.pdf /opt/compartidos/docs 2>/dev/null
mv /opt/compartidos/*.md /opt/compartidos/docs 2>/dev/null
mv /opt/compartidos/*.doc /opt/compartidos/docs 2>/dev/null
mv /opt/compartidos/*.odt /opt/compartidos/docs 2>/dev/null
mv /opt/compartidos/*.docx /opt/compartidos/docs 2>/dev/null
mv /opt/compartidos/*.txt /opt/compartidos/docs 2>/dev/null

```
#### Parte D
```bash
#!bin/bash
mv /opt/compartidos/*.sql /opt/compartidos/recovery 2>/dev/null

```
