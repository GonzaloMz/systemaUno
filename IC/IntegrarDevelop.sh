

#Actualizar develop

git checkout develop
git pull --rebase

#Ejecutar pruebas
cd ../QA/
./RunAllTest.sh > ../IC/integration_log.txt
