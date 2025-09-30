#!bin/bash

##1. Dentro de tu home, 
##crea un directorio principal llamado `proyecto`.
mkdir -p proyecto/ {docs,src/modulos,config,logs/backup,test/resultados} 
touch ./proyecto/docs/ {manual.txt,guía.txt,referencias.txt} ; touch ./proyecto/src/ {script1.sh,script2.sh} ; touch ./proyecto/src/modulos modulo1.py ; touch ./proyecto/config/ {app.cfg,db.cfg} 
touch ./proyecto/logs/ {access.log,error.log}; touch ./proyecto/logs/backup backup1.log 
touch ./proyecto/test/ {test1.txt,test2.txt};  touch ./proyecto/test/resultados resultados1.txt

### Ejercicio 2
##1. Copia los archivos `manual.txt` y `guia.txt` desde el subdirectorio `docs` a un nuevo subdirectorio llamado `backup_docs` dentro de `proyecto`.
##2. Copia de forma recursiva el directorio `config` completo junto con su contenido a un subdirectorio llamado `config_backup` dentro de `proyecto`.
##*Responde con los comandos utilizados y verifica la estructura resultante con `ls` o `tree`.*
mkdir -p proyecto/ {backup_docs,config_backup}
cd ./proyecto/docs/ 
cp proyecto/docs {manual.txt,guia.txt} proyecto/backup_docs
cp -r proyecto/{config} proyecto/config_backup
ls proyecto/