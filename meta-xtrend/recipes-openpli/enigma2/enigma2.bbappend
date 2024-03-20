FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:et1x000 = "\
	file://About.patch \
	file://InfoBar.patch \
	file://InfoBarGenerics.patch \
	file://Hotkey.patch \
	file://UsageConfig.patch \
	file://ru-po.patch \
	file://menu.patch \
	file://setup.patch \
	file://keymap.patch \
	file://Picon.patch \
	"

