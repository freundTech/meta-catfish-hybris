require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the Ticwatch Pro"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "catfish"

SRC_URI = "git://android.googlesource.com/kernel/msm;branch=android-msm-catshark-3.18-pie-wear-dr;protocol=https \
    file://0001-Revert-arm-kernel-refactor-the-CPU-suspend-API-for-r.patch \
    file://0002-Fix-include-in-bcm_gps_hostwake.c.patch \
    file://0003-Removed-unused-import.patch \
    file://0004-Fixed-more-include-errors.patch \
    file://0005-Add-missing-include.patch \
    file://0007-Fixed-MSM8909-Kconfig.patch \
    file://defconfig \
    file://wcd9335.cfg \
    file://img_info"
SRCREV = "27e2a71e1013c26731296a2d81ee3d88546b5d6f"
LINUX_VERSION ?= "3.18"
PV = "${LINUX_VERSION}+pie"
S = "${WORKDIR}/git"
B = "${S}"

do_install_append() {
    rm -rf ${D}/usr/src/usr/
}

BOOT_PARTITION = "/dev/mmcblk0p21"

inherit mkboot old-kernel-gcc-hdrs
