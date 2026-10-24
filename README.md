# java-package

![Java CI](https://github.com/hexlet-boilerplates/java-package/actions/workflows/main.yml/badge.svg)

A project template with only the bare minimum of structure. A good starting point for a small project.

## Start

```bash
make
```

## Setup

```bash
make build
```

## Run

```bash
make run
```

## Run tests

```bash
make test
```

## Run linter

```bash
make lint
```

## Check update dependencies and plugins

```bash
make update-deps
```

## Requirements

The project needs [mise](https://mise.jdx.dev/). It installs Java and Gradle from `mise.toml`:

```bash
mise install
```

`make install` also installs the Git hooks with [hk](https://hk.jdx.dev): a fast lint before each commit and the tests before each push. CI runs the same checks with `hk check --all`.

[![Hexlet Ltd. logo](https://raw.githubusercontent.com/Hexlet/assets/master/images/hexlet_logo128.png)](https://hexlet.io/?utm_source=github&utm_medium=link&utm_campaign=java-package)

This repository is created and maintained by the team and the community of Hexlet, an educational project. [Read more about Hexlet](https://hexlet.io/?utm_source=github&utm_medium=link&utm_campaign=java-package).
