do_install:append() {
    echo  'UUID=984926b4-93ed-4ba9-ab6d-2f3e6f9d23aa    /media/usb  ext4    defaults    0   2'  >>  ${D}${sysconfdir}/fstab
    echo  'UUID=6311-92D0     /media/hdd  auto    defaults    0   0'                                            >>  ${D}${sysconfdir}/fstab
    echo  'UUID=4c889f34-3cb9-4151-aa26-c218fb4006e1    none    swap    sw    0    0'              >>  ${D}${sysconfdir}/fstab


    printf "${DISTRO_NAME} ${DISTRO_VERSION} ${DATE} " > ${D}${sysconfdir}/issue
    printf "\\\n \\\l\n" >> ${D}${sysconfdir}/issue
    echo >> ${D}${sysconfdir}/issue

    echo  'edition by Vasiliks'  >>  ${D}${sysconfdir}/issue.net
    echo  '%s %r %m'  >>  ${D}${sysconfdir}/issue.net
    echo  '%d, %t '  >>  ${D}${sysconfdir}/issue.net
    echo  ''  >>  ${D}${sysconfdir}/issue.net
}

