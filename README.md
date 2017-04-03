# cinemabooking
Designation: Ticket booking service/
Stack of technologies: Spring web, JAXB, XML, AJAX, JSON, Tiles, Maven, Tomcat/            
Follow the instructions of README to launch the application/


Прилложение осуществляет следующий функционал:
1) Просмотр расписания фильмов;
2) Просмотр схемы мест зала, выбор и бронирование мест;
3) Просмотр списка брони с возможностью удаления заказа;
4) Поиск заказа по его ID;

Для передачи данных на сервер используется формат данных JSON посредством AJAX функций для динамики и умньшения объема информации.

Перед деплоем проекта требуется изменить имена переменных, указывающих пути к файлам XML("order.xml","cinema.xml").
эти переменные инициализируются в классе DataConverter.java в модуле dao.
Пример корректного пути: 
    "C:/Projects/cinemabooking/dao/src/main/java/com/voronovich/cinema.xml";
    "C:/Projects/cinemabooking/dao/src/main/java/com/voronovich/order.xml".
    
Параметры сервера Tomcat:
версия: Apache Tomcat 9.0.0.M13;
port: 8080;
user: tomcat;
password: tomcat;
start page: http://localhost:8080/web/ .

Библиотеки/версии:
        <java.version>1.8</java.version>
        <spring.version>4.3.6.RELEASE</spring.version>
        <cobertura.version>2.7</cobertura.version>
        <info-reports-plugin.version>2.9</info-reports-plugin.version>
        <javax.servlet-api.version>3.1.0</javax.servlet-api.version>
        <compiler-plugin.version>3.1</compiler-plugin.version>
        <jsp-api.version>2.0</jsp-api.version>
        <jstl.version>1.2</jstl.version>
        <log4j.version>1.2.17</log4j.version>
        <aspectj.version>1.7.3</aspectj.version>
        <cglib.version>3.2.4</cglib.version>
        <tiles.version>3.0.5</tiles.version>
А также зависимости:
            <dependency>
              <groupId>com.fasterxml.jackson.core</groupId>
              <artifactId>jackson-databind</artifactId>
              <version>2.5.3</version>
            </dependency>
            <dependency>
              <groupId>com.sun.xml.bind</groupId>
              <artifactId>jaxb-core</artifactId>
              <version>2.3.0-b170127.1453</version>
            </dependency>
            <dependency>
              <groupId>com.sun.xml.bind</groupId>
              <artifactId>jaxb-impl</artifactId>
              <version>2.3.0-b170127.1453</version>
            </dependency>
        



