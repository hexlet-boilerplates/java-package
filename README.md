# java-package

[![Build Status](https://jitpack.io/v/hexlet-boilerplates/java-package.svg)](https://jitpack.io/#hexlet-boilerplates/java-package)
[![Build Status](https://travis-ci.org/hexlet-boilerplates/java-package.svg?branch=master)](https://travis-ci.org/hexlet-boilerplates/java-package)

Типовой проект со всей минимально-необходимой структурой. Подойдёт в качестве отправной точки для небольшого проекта. 

## Start

$ make

## Setup
$ make build

## Run
$ make run

## Run tests
$ make test

## Update dependencies and plugins
$ make update

## Jenv
http://www.jenv.be/  
В *nix и macOS рекомендуется для управления версиями Java\`ы использовать утилиту jenv. 

### Как установить Jenv на Linux / OS X
`$ git clone https://github.com/gcuisinier/jenv.git ~/.jenv`

### Установка на Mac OS X через Homebrew
`$ brew install jenv`

### Конфигурирование
`$ jenv add /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home`

`$ jenv add /Library/Java/JavaVirtualMachines/jdk17011.jdk/Contents/Home`

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
   