// Copied from OATemplate project by OABuilder 06/20/21 11:44 AM
@XmlJavaTypeAdapters({
		@XmlJavaTypeAdapter(type = OADateTime.class, value = OADateTimeXmlAdapter.class),
		@XmlJavaTypeAdapter(type = OADate.class, value = OADateXmlAdapter.class),
		@XmlJavaTypeAdapter(type = OATime.class, value = OATimeXmlAdapter.class)
})
package com.viaoa.docbuilder.model.oa;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.viaoa.jaxb.adapter.OADateTimeXmlAdapter;
import com.viaoa.jaxb.adapter.OADateXmlAdapter;
import com.viaoa.jaxb.adapter.OATimeXmlAdapter;
import com.viaoa.util.OADate;
import com.viaoa.util.OADateTime;
import com.viaoa.util.OATime;
