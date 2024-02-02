2.	Java web приложение, выполняющее основную логику (желательно Spring Boot)
 2.1.	Осуществлять подключение и операции в БД (желательно средствами Java Persistence API)

 2.2.	SOAP сервис с методом создания расписания, который по переданным правилам создаёт слоты времени.
        Правила могут состоять из даты/времени начала расписания, продолжительность талона (слота времени),
        их количество и т. д. Можно применить более сложную структуру правил, если будет желание.
  - WSDL лежит по адресу: http://localhost:8080/ws/createTimeTable.wsdl
  - обращение к сервису по адресу http://localhost:8080/ws/

--Не удалось до конца разобраться с пространствои имен, поэтому, postman по WSDL'ке генерирует следующий запрос

<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <tns:createTimeTableRequest xmlns="http://spring.io/guides/gs-producing-web-service">
      <tns:date>string</tns:date>
      <tns:startTime>string</tns:startTime>
      <tns:endTime>string</tns:endTime>
      <tns:period>100</tns:period>
      <tns:duration>100</tns:duration>
      <tns:quartzTimesPerDay>100</tns:quartzTimesPerDay>
    </tns:createTimeTableRequest>
  </soap:Body>

  
--Корректно выполняется следующий запрос (разница в пространстве имен):
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <createTimeTableRequest xmlns="http://spring.io/guides/gs-producing-web-service">
      <name>string</name>
      <date>string</date>
      <startTime>string</startTime>
      <endTime>string</endTime>
      <period>100</period>
      <duration>100</duration>
      <quartzTimesPerDay>100</quartzTimesPerDay>
    </createTimeTableRequest>
  </soap:Body>
</soap:Envelope>

  
2.3.	REST сервис работы с методами:
 2.3.1.	получение свободных слотов времени к указанному врачу на указанную дату
  - обращение к сервису по адресу http://localhost:8080/api/getTickets
  - public List<Ticket> getTicketsByDateAndDoctorId(LocalDateTime date, int doctorId)
    
2.3.2.	занятие слота времени по его id (предположил, что не передавая пациента вместе с id слота, слот не занять)
  - обращение к сервису по адресу http://localhost:8080/api/takeTicketsById
  - public void takeTicketsById(int ticketId, Patient patient)
    
2.3.3.	получение всех слотов времени, занятых одним пациентом по id/uuid
  - обращение к сервису по адресу http://localhost:8080/api/getTicketsByPatientId
  - public List<Ticket> getTicketsByPatientId(int patientId)

  - обращение к сервису по адресу http://localhost:8080/api/getTicketsByPatientUuid
  - public List<Ticket> getTicketsByPatientUuid(String patientUuid)


В файле script.sql в корне проекта лежит скрипт для создания 3 таблиц и заполнения таблиц врачей и пациентов

Некоторые классы пакета util не функциональны, но служили для сборки базы данных. Пока что, решил не удалять.

Для запуска проекта потребуется корректировка файла application.properties- для конфигурации базы данных на машине того, кто будет оценивать работу.


С SOAP работаю впервые, надеюсь, что не сильно испортил технологию)

Хотелось бы получить, по возможности, развернутую реакцию на работу.
