MODULE = "Blackoutblind"
DESCRIPTION = "Hide white dotted lines (VBI) on top of the screen"

PV_MOD = "1.0+git"
PKGV_MOD = "1.0+git${GITPKGV}"

require openplugins.inc
inherit setuptools3-openplugins

BRANCH = "master"
