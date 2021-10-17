SUMMARY = "Provides cryptographic recipes and primitives to python developers"
HOMEPAGE = "https://cryptography.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bf405a8056a6647e7d077b0e7bc36aba"

LDSHARED += "-pthread"

SRC_URI[sha256sum] = "94cc5ed4ceaefcbe5bf38c8fba6a21fc1d365bb8fb826ea1688e3370b2e24a1c"

SRC_URI += " \
    file://run-ptest \
    file://h-test.patch \
"

export CRYPTOGRAPHY_DONT_BUILD_RUST = "1" 

inherit pypi setuptools3

DEPENDS += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-cffi-native \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-pip-native \
    ${PYTHON_PN}-setuptools-rust-native \
"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
"

RDEPENDS:${PN}:class-target += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-threading \
"

RDEPENDS:${PN}-ptest += " \
    ${PN} \
    ${PYTHON_PN}-cryptography-vectors \
    ${PYTHON_PN}-iso8601 \
    ${PYTHON_PN}-pretend \
    ${PYTHON_PN}-pytest \
    ${PYTHON_PN}-pytz \
"

inherit ptest

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
    install -d ${D}${PTEST_PATH}/tests/hazmat
    cp -rf ${S}/tests/hazmat/* ${D}${PTEST_PATH}/tests/hazmat/
}

FILES:${PN}-dbg += " \
    ${libdir}/${PYTHON_PN}2.7/site-packages/${SRCNAME}/hazmat/bindings/.debug \
"

BBCLASSEXTEND = "native nativesdk"
