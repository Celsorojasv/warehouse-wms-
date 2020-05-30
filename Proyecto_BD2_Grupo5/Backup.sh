#!/bin/bash
export CLASSPATH=.:${ORACLE_HOME}/jdbc/lib/ojdbc6.jar
cd /u01/app/oracle/product/11.2.0/xe/apex/utilities
## ejecuta backup de la App 100 
java oracle/apex/APEXExport -db localhost:1521:xe -user usuario -password clave 
-applicationid 100 >> /backup/log-aplicacion.log
##  copia el archivo generado de la aplicación a la carpeta backup
cp /u01/app/oracle/product/11.2.0/xe/apex/utilities/f*.sql /backup/
## Backup completo de la BD
su - oracle -c 'exp system/system file=/backup/backup.dmp log=/backup/log-backup.log  OWNER=GEXTIC'
## Se crea una carpeta con la fecha actual y se copian los ficheros dentro de ella
carpeta=$(date +"%d_%m_%y")
mkdir /backup/$carpeta
cp /backup/f*.sql  /backup/$carpeta
cp /backup/backup.dmp /backup/$carpeta