Лабораторная работа 5
Наследование, рефлексия.
1. Создать базовый и производный классы. Определить конструкторы, методы доступа, виртуальные методы (хотя бы toString()). Показать использование конструкторов этого же и базового класса. Можно определить некоторые константы или enum.

2. Разработать аннотацию, отметить, ей метод(ы) в классе, С помощью рефлексии обойти методы класса и вызвать отмеченные аннотацией методы с помощью invoke().
3.С помощью рефлексии вывести имя класса, а также согласно варианта:
Номер варианта	Задание 1	Задание 2
1,6,11,16,21	Список конструкторов с их параметрами	Модификаторы класса
2,7,12,17,22	Список методов с аннотациями и типами параметров	Название пакета и которкое (простое) имя класса
3,8,13,18	Список методов со спецификаторами доступа и типами параметров	Название суперкласса
4,9,14,19	Список полей с именами, типами и модификаторами доступа	Список аннотаций класса
5,10,15,20	Список интерфейсов реализованных классом	Список полей с типами и аннотациями
4)	* Сделать для класса прокси (для Immutability), который пропускает обращение к getter' ам , а на сеттеры — бросает эксепшены.
5)	** Написать модульные тесты для *.
6)	*** Написать прокси для моканья.

Вариант 3 – Базовый класс – «окно» включающий координаты (left, top, right, bottom) и цвет окна, производный класс - «окно с текстом», включающий текст, цвет текста в окне;