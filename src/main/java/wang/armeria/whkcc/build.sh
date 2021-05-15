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

file_name=Whkcc

rm $file_name.y
touch $file_name.y
cat header.y >> $file_name.y
cat body.y >> $file_name.y
if [ "$debug" -eq 0 ]; then
    bison $file_name.y -g -x --report=all --warnings=none
fi
if [ "$debug" -eq 1 ]; then
    bison $file_name.y -g -x --report=all
fi
if [ "$debug" -eq 2 ]; then
    bison $file_name.y -g -x --report=all -Wcounterexamples
fi
