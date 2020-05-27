FILESEXTRAPATHS_prepend_catfish := "${THISDIR}/${PN}:"

SRC_URI_append_catfish = " file://nonplat_property_contexts \
    file://plat_property_contexts"

do_install_append_catfish() {
    install -m 0644 ${WORKDIR}/nonplat* ${D}/
    install -m 0644 ${WORKDIR}/plat* ${D}/
}

FILES_${PN} += "/nonplat* /plat*"
