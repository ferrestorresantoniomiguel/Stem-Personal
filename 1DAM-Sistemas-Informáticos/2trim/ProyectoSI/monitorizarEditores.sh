#!/bin/bash
# [cite_start]Lista de editores según el PDF [cite: 13, 15]
EDITORES=("editor1" "editor2" "editor3" "editor4")

for usuario in "${EDITORES[@]}"
do
    # [cite_start]El PDF pide: pid, %mem, %cpu, user, command de los 5 procesos que más consumen [cite: 40]
    ps -u "$usuario" -o pid,%mem,%cpu,user,comm --sort=-%mem | head -n 6 > "/opt/compartido/$usuario"
done