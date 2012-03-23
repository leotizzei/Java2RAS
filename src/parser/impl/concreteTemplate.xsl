<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="UTF-8" indent="yes" method="xml" version="1.0"/>
<!-- get the name of the class and set the artifacts names -->
	<xsl:template match="java-source-program">
		<asset version="1.0.1" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="file:/home/lsd/ra001973/mestrado/EvolutionChecker/documentos/concreteprofile.xsd">
			<profile name="concretecomponent" versionMajor="1" versionMinor="0">
				<relatedasset/>
				<relatedprofile>
					<description/>
				</relatedprofile>
				<description/>
			</profile>
			<solution>
				<design>
					<diagram>
						<artifact>
							<artifactcontext/>
							<artifactdependency/>
							<artifacttype/>
							<variabilitypoint/>
						</artifact>
					</diagram>
					<model>
						<diagramdependency/>
						<modeldependency/>
						<artifact>
							<artifactcontext/>
							<artifactdependency/>
							<artifacttype/>
							<variabilitypoint/>
						</artifact>
					</model>
				</design>
				<test>
					<diagram>
						<artifact>
							<artifactcontext/>
							<artifactdependency/>
							<artifacttype/>
							<variabilitypoint/>
						</artifact>
					</diagram>
					<artifact>
						<artifactcontext/>
						<artifactdependency/>
						<artifacttype/>
						<variabilitypoint/>
					</artifact>
					<model>
						<diagramdependency/>
						<modeldependency/>
						<artifact>
							<artifactcontext/>
							<artifactdependency/>
							<artifacttype/>
							<variabilitypoint/>
						</artifact>
					</model>
				</test>
				<implementation abstractCompVersion="1.0.1">
					<elementarycomponent>
						<xsl:for-each select="descendant::class">
							<artifact type="java">
								<xsl:attribute name="name">
									<xsl:value-of select="@name"/>
								</xsl:attribute>
								<artifactcontext/>
								<artifactdependency/>
								<artifacttype type="java"/>
								<variabilitypoint/>
							</artifact>
						</xsl:for-each>
						<artifact/>
					</elementarycomponent>
					<relatedasset/>
				</implementation>
			</solution>
			<description/>
			<usage>
				<assetactivity>
					<activity>
						<description/>
						<varibilitypointbinding/>
					</activity>
				</assetactivity>
				<artifactactivity>
					<activity>
						<description/>
						<varibilitypointbinding/>
					</activity>
				</artifactactivity>
				<contextref>
					<activity>
						<description/>
						<varibilitypointbinding/>
					</activity>
				</contextref>
			</usage>
			<classification>
				<descriptorgroup>
					<description/>
					<descriptor/>
				</descriptorgroup>
				<context>
					<description/>
					<descriptorgroup>
						<description/>
						<descriptor/>
					</descriptorgroup>
				</context>
			</classification>
		</asset>
	</xsl:template>
</xsl:stylesheet>
