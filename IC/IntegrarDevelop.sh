

#Actualizar develop
git checkout develop
git pull --rebase



#Ejecutar pruebas (RunAllTest realiza la tarea de iniciar el server para las pruebas)
cd ../QA/
./RunAllTest.sh > ../IC/integration_log.txt
