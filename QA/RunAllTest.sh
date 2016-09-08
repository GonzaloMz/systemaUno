
#Regresión de pruebas funcionales
#Hay que poder customizar el puerto

#Inicia el server
node ../app.js > server_log.txt &
SERVER_PID=$!
SERVER_OUT=$(tail -n 1 server_log.txt);
while [ "$SERVER_OUT" != "Express server listening on port 3000 in development mode" ]; 
do
SERVER_OUT=$(tail -n 1 server_log.txt);
done
echo $SERVER_OUT;




#ACtualiza el path para setear el jdk y corre los tests
PATH_BACKUP=$PATH;
PATH=/usr/lib/jvm/jdk-8-oracle/:/usr/lib/jvm/jdk-8-oracle/bin/:$PATH

mvn test -Dwebdriver.firefox.marionette=false -Dtest.url="http://127.0.0.1:3000" -f pomFunctionalTest.xml

PATH=$PATH_BACKUP;



#Mata el server
kill -9 "$SERVER_PID"
