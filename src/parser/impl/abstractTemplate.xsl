<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"
		version="1.0" />
	<!-- get the name of the class and set the artifacts names -->
	<xsl:template match="java-source-program">
		<asset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:noNamespaceSchemaLocation="file:/home/lsd/ra001973/mestrado/verificador/desenvolvimento/abstractprofile.xsd"
			name="" id="" version="">
			<profile>
				<relatedasset name="" id="" version=""/>
				<relatedprofile>
					<description />
				</relatedprofile>
				<description />
			</profile>
			<solution>
				<design>
					<model>
						<diagramdependency />
						<modeldependency />
						<artifact>
							<artifactcontext />
							<artifactdependency />
							<artifacttype />
							<variabilitypoint />
						</artifact>
					</model>
					<diagram>
						<artifact>
							<artifactcontext />
							<artifactdependency />
							<artifacttype />
							<variabilitypoint />
						</artifact>
					</diagram>
					<abstractcomponent targetplatform="java">
						<externalproperty>
							<contextdependency>
								<xsl:for-each
									select="descendant::interface">
									<interface>
										<xsl:attribute name="name">
											<xsl:value-of
												select="@name" />
										</xsl:attribute>
									</interface>
								</xsl:for-each>
							</contextdependency>
						</externalproperty>
					</abstractcomponent>
				</design>
				<test>
					<diagram>
						<artifact>
							<artifactcontext />
							<artifactdependency />
							<artifacttype />
							<variabilitypoint />
						</artifact>
					</diagram>
					<artifact>
						<artifactcontext />
						<artifactdependency />
						<artifacttype />
						<variabilitypoint />
					</artifact>
					<model>
						<diagramdependency />
						<modeldependency />
						<artifact>
							<artifactcontext />
							<artifactdependency />
							<artifacttype />
							<variabilitypoint />
						</artifact>
					</model>
				</test>

			</solution>
			<description />
			<usage>
				<assetactivity>
					<activity>
						<description />
						<varibilitypointbinding />
					</activity>
				</assetactivity>
				<artifactactivity>
					<activity>
						<description />
						<varibilitypointbinding />
					</activity>
				</artifactactivity>
				<contextref>
					<activity>
						<description />
						<varibilitypointbinding />
					</activity>
				</contextref>
			</usage>
			<classification>
				<descriptorgroup>
					<description />
					<descriptor />
				</descriptorgroup>
				<context>
					<description />
					<descriptorgroup>
						<description />
						<descriptor />
					</descriptorgroup>
				</context>
			</classification>
		</asset>
	</xsl:template>
</xsl:stylesheet>
