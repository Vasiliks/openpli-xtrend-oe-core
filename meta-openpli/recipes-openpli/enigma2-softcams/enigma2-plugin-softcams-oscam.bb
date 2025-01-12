require conf/license/openpli-gplv2.inc
require softcam.inc
inherit cmake gitpkgv 

DESCRIPTION = "OScam ${PV} Open Source Softcam"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PV = "1.20+git"
PKGV = "1.20+git${GITPKGV}"

SRC_URI = "git://repo.or.cz/oscam.git;protocol=https;branch=master"

DEPENDS = "libusb openssl libdvbcsa"

LDFLAGS:prepend = "-ludev -ldvbcsa "
EXTRA_OECONF = "LIBDVBCSA=yes "

S = "${WORKDIR}/git"
B = "${S}"

CAMNAME = "oscam"
CAMSTART = "exec start-stop-daemon -S -x /usr/bin/oscam -- -b -r 2 -c /etc/tuxbox/config/oscam"
CAMSTOP =  "exec start-stop-daemon -K -R 2 -x /usr/bin/oscam"

SRC_URI += " \
	file://oscam.conf \
	file://oscam.server \
	file://oscam.srvid \
	file://oscam.user \
	file://oscam.provid"

CONFFILES = "${sysconfdir}/tuxbox/config/oscam/oscam.conf ${sysconfdir}/tuxbox/config/oscam/oscam.server ${sysconfdir}/tuxbox/config/oscam/oscam.srvid ${sysconfdir}/tuxbox/config/oscam/oscam.user ${sysconfdir}/tuxbox/config/oscam/oscam.provid"

FILES:${PN} = "${bindir}/oscam ${sysconfdir}/tuxbox/config/oscam/* ${sysconfdir}/init.d/softcam.oscam"

EXTRA_OECMAKE += "\
	-DOSCAM_SYSTEM_NAME=Tuxbox \
	-DWEBIF=1 \
	-DWITH_STAPI=0 \
	-DHAVE_LIBUSB=1 \
	-DSTATIC_LIBUSB=1 \
	-DWITH_SSL=1 \
	-DIPV6SUPPORT=1 \
	-DCLOCKFIX=0 \
	-DHAVE_PCSC=1 \
	-DCARDREADER_SMARGO=1 \
	-DCARDREADER_PCSC=1 \
	-DCW_CYCLE_CHECK=1 \
	-DCS_CACHEEX=1 \
	-DMODULE_CONSTCW=1 \
	-DMODULE_SCAM=1 \
	-DMODULE_STREAMRELAY=1 \
	"

do_install() {
	install -d ${D}${sysconfdir}/tuxbox/config/oscam
	install -m 0644 ${WORKDIR}/oscam.* ${D}${sysconfdir}/tuxbox/config/oscam/
	install -d ${D}${bindir}
	install -m 0755 ${B}/oscam ${D}${bindir}
}
