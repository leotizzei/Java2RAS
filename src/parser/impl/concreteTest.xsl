<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="UTF-8" indent="yes" method="xml" version="1.0"/>
<!-- get the name of the class and set the artifacts names -->
	<xsl:template match="asset">
		<asset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="file:/home/lsd/ra001973/mestrado/verificador/desenvolvimento/concreteprofile.xsd">
			<compositecomponent>
				<xsl:for-each select="descendant::class">
					<artifact>
						<xsl:attribute name="name">
							<xsl:value-of select="@name"/>
						</xsl:attribute>
					</artifact>
				</xsl:for-each>
			</compositecomponent>
		</asset>
	</xsl:template>
</xsl:stylesheet>
