debug=1
while getopts "d:" arg; do
    case $arg in
    d)
        debug=$OPTARG
        ;;
    ?)
        echo_usage
        exit
        ;;
    esac
done

rm Whkcc.y
touch Whkcc.y
cat header.y >> Whkcc.y
cat body.y >> Whkcc.y
if [ "$debug" -eq 0 ]; then
    bison Whkcc.y -g -x --warnings=none
fi
if [ "$debug" -eq 1 ]; then
    bison Whkcc.y -g -x
fi
if [ "$debug" -eq 2 ]; then
    bison Whkcc.y -g -x -Wcounterexamples
fi