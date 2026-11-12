# AGENTS.md

Шаблон пакета на Java и Gradle. Код лежит в `src/main`, тесты в `src/test`.

## Команды

| Команда | Что делает |
| --- | --- |
| `make install` | Ставит git-хуки и собирает дистрибутив в `build/install` |
| `make build` | Собирает проект с нуля |
| `make run` | Запускает приложение через Gradle |
| `make run-dist` | Запускает собранный дистрибутив |
| `make test` | Запускает тесты |
| `make test-coverage` | Запускает тесты и проверяет порог покрытия JaCoCo |
| `make report` | Строит HTML-отчёт о покрытии |
| `make lint` | Проверяет форматирование через Spotless и компилирует код и тесты |
| `make lint-fix` | Исправляет форматирование |
| `make setup` | Обновляет Gradle wrapper |
| `make update-deps` | Поднимает версии в каталоге зависимостей |

## Проверки

`make lint` также проверяет Markdown (`rumdl`), опечатки (`typos`) и workflow GitHub Actions (`jactionlint`). `make install` ставит git-хуки hk, перед коммитом они запускают `make lint`, перед push `make test`.

Перед завершением задачи запусти `make lint` и `make test`, обе команды должны проходить.

## Окружение

Инструменты и их версии задаёт `mise.toml`, ставит их `mise install`.
