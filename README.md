# qaguru_homework_12.5

## <img width="4%" title="Contents" src="images/logo/contents.png"> Содержание

> ➠ [Покрытый функционал](#-покрытый-функционал)
>
> ➠ [Технологический стек](#-технологический-стек)
>
> ➠ [Запуск тестов из терминала](#-запуск-тестов-из-терминала)
>
> ➠ [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
>
> ➠ [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-allure-report)
>
> ➠ [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
>
> ➠ [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)


## <img width="4%" title="Functional" src="images/logo/functional.png"> Покрытый функционал

> Разработаны автотесты на <code>UI</code>.
### UI

- [x] Проверка отображения страницы поиска товаров
- [x] Отсутствие ошибок в журнале консоли страницы
- [x] Проверка количества найденного товара
- [x] Проверка списка брендов
- [x] Проверка фильтра товаров
- [x] Проверка ошибки "По Вашему запросу ничего не найдено"
- [x] Проверка ошибки "Извините, не удалось обработать ваш запрос."
- [x] Проверка отображения картинки при неправильном запросе
- [x] Проверка поиска большого значения
- [x] Проверка смешанного типа запроса

[Вернуться к содержанию](#-содержание) :top:

## <img width="4%" title="Technologies" src="images/logo/technologies.png"> Технологический стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

 В данном проекте автотесты написаны на <code>Java</code> с использованием <code>Selenide</code> для UI-тестов.
>
> <code>Selenoid</code> выполняет запуск браузеров в контейнерах <code>Docker</code>.
>
> <code>Allure Report</code> формирует отчет о запуске тестов.
>
> Для автоматизированной сборки проекта используется <code>Gradle</code>.
>
> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>.
>
> <code>Jenkins</code> выполняет запуск тестов.
> После завершения прогона отправляются уведомления с помощью бота в <code>Telegram</code>.
[Вернуться к содержанию](#-содержание) :top:

## <img width="4%" title="Terminal" src="images/logo/terminal.png"> Запуск тестов из терминала

### :joystick: Локальный запуск тестов

```
gradle clean
```

### :joystick: Удаленный запуск тестов 

```
clean
test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://user1:1234@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

### :joystick: Параметры сборки

> <details>
> <summary> :point_left: <code>TASK</code> – список тестов, сгруппированных по параметру тега. В зависимости от выбранного параметра будут запускаться определенные группы тестов.</summary>
>
> **Доступные варианты:**
>
> + <code>test</code> – запуск всех тестов
> + <code>high_priority_tests</code> – запуск высокоприоритетных тестов с тегами _Critical_, _Highest_, _Blocker_, _High_
> + <code>web_test</code> – запуск тестов с тегом _Web_
> </details>
>
> <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.
>
> <code>BROWSER</code> – браузер, в котором будут выполняться тесты (_по умолчанию - <code>chrome</code>_).
>
> <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты (_по умолчанию - <code>91.0</code>_).
>
> <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты (_по умолчанию - <code>1920x1080</code>_).
>
> <code>THREADS</code> – количество потоков для запуска тестов.


