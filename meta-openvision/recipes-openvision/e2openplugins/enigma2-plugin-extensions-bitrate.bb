MODULE = "Bitrate"
DESCRIPTION = "Bitrate viewer"

require conf/license/license-gplv2.inc

require openplugins-replace-pli.inc
PR="r1.2"

require openplugins.inc

inherit autotools gettext

DEPENDS += "python3"

SRC_URI = " git://github.com/E2OpenPlugins/e2openplugin-Bitrate.git;branch=python3 \
			file://hack-for-python390.patch \
			"

EXTRA_OECONF = " \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR}"

FILES:${PN} = "${libdir} ${bindir}"
