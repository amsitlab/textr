#!/data/data/com.termux/files/usr/bin/bash


if test -z "$(which commandex)"; then
	printf "commandex program not installed\n"
	printf "please contact author for installing it\n"
	exit 1
fi

commandex jar
