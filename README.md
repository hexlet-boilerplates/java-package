# java-package

[![Build Status](https://jitpack.io/v/hexlet-boilerplates/java-package.svg)](https://jitpack.io/#hexlet-boilerplates/java-package)
![Java CI](https://github.com/TanyFV/java-package/workflows/Java%20CI/badge.svg)

Типовой проект со всей минимально-необходимой структурой. Подойдёт в качестве отправной точки для небольшого проекта.

## Start

$ make

## Setup
```bash
$ make build
```

## Run
```bash
$ make run
```

## Run tests
```bash
$ make test
```

## Update dependencies and plugins
```bash
$ make update
```

## Jenv
В *nix и macOS для управления версиями Java\`ы рекомендуется использовать утилиту jenv http://www.jenv.be/ . 

### Как установить Jenv на Linux / OS X
```bash
$ git clone https://github.com/gcuisinier/jenv.git ~/.jenv
```

### Установка на Mac OS X через Homebrew
```bash
$ brew install jenv
```

### Конфигурирование
```bash
$ jenv add /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home
```

```bash
$ jenv add /Library/Java/JavaVirtualMachines/jdk17011.jdk/Contents/Home`
```

### Usage
   * List managed JDKs%
      ```bash
     jenv versions
      ```
   * Configure local version (in root directory)
      ```bash
     $ jenv local 10.0.2
      ```
   * add .java-version to `.git/info/exclude` or `~/.gitignore_global`
   
[![Hexlet Ltd. logo](https://raw.githubusercontent.com/Hexlet/hexletguides.github.io/master/images/hexlet_logo128.png)](https://ru.hexlet.io/pages/about?utm_source=github&utm_medium=link&utm_campaign=java-package)

This repository is created and maintained by the team and the community of Hexlet, an educational project. [Read more about Hexlet (in Russian)](https://ru.hexlet.io/pages/about?utm_source=github&utm_medium=link&utm_campaign=java-package).
