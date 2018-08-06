# Textr (Text runner)
A simple text runner for [Termux](https://termux.net) App.

### Jump To
* [Install](#Install)
* [Run](#Run)
* [Buildwith](#Builtwith)
* [Author](#Author)


### Inatall

```bash
git clone https://github.com/amsitlab/textr
```

For running as global program, you must be install debian package on this project root directory, by typing:
```bash
apt install ./textr_1.0_all.deb
```

### Run 
> Required installing as global program.

```bash
textr --sleep 100 "Hy" "(@red)I'm red(@end)"
```

Run file text contents.
```bash 
textr --sleep 100 --file example/file.textr
```


### Builtwith
* [Picocli](https://github.com/remkop/picocli)
* [commandex](https://amsitlab.github.io/) simple project builder for creating dex executable program by me.

