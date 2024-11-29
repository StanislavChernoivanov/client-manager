Описание API:
1. Запрос для создания нового клиента. Например
    url - http://localhost:8080/api/v1/client (http-метод POST)
    request body - {"name": "myname"}

2. Запрос для получения всех клиентов
   url - http://localhost:8080/api/v1/client (http-метод GET)

3. Запрос для получения всех клиентов (в приложении id генерируется случаным набором символов, чтобы проверить API можно сначала получить всех клиентов, скопировать любой id, и в ставить в запрос с поиском клиента по id)
      url - http://localhost:8080/api/v1/client/{id} (http-метод GET)

4. Запрос для добавления контакта по id клиента. Тип контакта не указывается, приложение вычисляет его самостоятельно. Главное следовать паттерну: для номера телефона - 89776665544, для почты - email@email.ru. Например
      url - http://localhost:8080/api/v1/client/{id}?contact=myemail@email.ru (http-метод PATCH)
      url - http://localhost:8080/api/v1/client/{id}?contact=89776665544

5. Запрос для получения всех контактов по id клиента. Например
      url - http://localhost:8080/api/v1/client/{id}/contacts (http-метод GET)

6. Запрос для получения всех контактов по id клиента и типу контакта. Типы контактов: EMAIL, PHONE. Например
      url - http://localhost:8080/api/v1/client/{id}/contacts/withType?contactType=EMAIL (http-метод GET)
      url - http://localhost:8080/api/v1/client/{id}/contacts/withType?contactType=PHONE