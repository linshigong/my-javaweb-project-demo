URTIME=$(date +%y%m%d%H%M%S)

help_info(){
        echo "-d deploy"
        echo "-r recover"
        echo "-v verify ip dir filename"
}

if [ $# -eq 0 ]
then 
        echo Help Info:
        echo
        help_info
        echo
        exit 0
fi

deploy()
{
        echo ------------------------------------------------------------
        echo ;
        echo deploy start;
        echo ;
        echo a. stop jetty;
        sh /opt/jetty/bin/jetty.sh stop;
        echo ;

        echo b. backup old file;
        cp ./old/voicepairserver.war.old ./old/voicepairserver.war.old.${CURTIME} -fv;
        cp ./old/libVoicePair.so.old ./old/libVoicePair.so.old.${CURTIME} -fv;
        cp ./old/relayserver.war.old ./old/relayserver.war.old.${CURTIME} -fv;
        echo ;
        cp /opt/jetty/webapps/voicepairserver.war ./old/voicepairserver.war.old -fv;
        cp /usr/voicepairserver/lib/libVoicePair.so ./old/libVoicePair.so.old -fv;
        cp /opt/jetty/webapps/relayserver.war ./old/relayserver.war.old -fv;
        echo ;

        echo c. deploy new file;
        cp ./new/libVoicePair.so /usr/voicepairserver/lib -fv;
        cp ./new/voicepairserver.war /opt/jetty/webapps -fv;
        cp ./new/relayserver.war /opt/jetty/webapps -fv;
        echo ;

        echo d. start jetty;
        sh /opt/jetty/bin/jetty.sh restart
        echo ;
        echo deploy over;
        echo ;
        echo ------------------------------------------------------------
}

recover()
{
        echo ------------------------------------------------------------
        echo ;
        echo revover start;
        echo ;

        echo a. stop jetty;
        sh /opt/jetty/bin/jetty.sh stop;
        echo ;

        echo b. deploy old file;
        cp ./old/libVoicePair.so.old /usr/voicepairserver/lib/libVoicePair.so -fv;
        cp ./old/voicepairserver.war.old /opt/jetty/webapps/voicepairserver.war -fv;
        cp ./old/relayserver.war.old /opt/jetty/webapps/relayserver.war -fv;
        echo ;

        echo c. start jetty;
        sh /opt/jetty/bin/jetty.sh restart
        echo ;
        echo recover over;
        echo ;
        echo ------------------------------------------------------------
}

verify()
{
        echo ------------------------------------------------------------
        echo ;
        echo verify data start;
        echo ;

        echo a. logn to dest host=$2;
        echo `ssh $2 -lchengs 'md5sum '$3/$4'&& exit'`
        exit 0

}
options()
{
        while [ -n "$1" ]
        do
        case "$1" in

                -d)
                deploy
                ;;

                -r)
                recover
                ;;

                -v)
                verify $*
                ;;

                *)
                echo "$1 is not an option"
                ;;
        esac
        shift
        done
}

options $*

