<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="UTF-8" indent="yes" method="xml"
		version="1.0" />
	<!-- get the name of the class and set the artifacts names -->
	<xsl:template match="java-source-program">
		<asset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:noNamespaceSchemaLocation="file:/home/lsd/ra001973/workspace2/EvolutionChecker/src/java/evolutionChecker/abstractprofile_v2.xsd"
			name="" id="" version="1.0.1">
			<profile name="abstractcomponent" versionMajor="1" versionMinor="0">
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
					<abstractcomponent name="" targetplatform="java">
						<externalproperty>
							<contextdependency>
								<xsl:for-each
									select="descendant::interface">
									<interface state="normal">
										<xsl:attribute name="name">
											<xsl:value-of
												select="@name" />
										</xsl:attribute>
										<xsl:variable name="package"
											select="preceding-sibling::package-decl/@name" />
										<xsl:if
											test="contains($package,'req')">
											<xsl:attribute
												name="direction">
												<xsl:text>required</xsl:text>
											</xsl:attribute>
										</xsl:if>
										<xsl:if
											test="contains($package,'prov')">
											<xsl:attribute
												name="direction">
												<xsl:text>provided</xsl:text>
											</xsl:attribute>
										</xsl:if>

										<relatedasset></relatedasset>
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
			<relatedasset/>
		</asset>
	</xsl:template>
</xsl:stylesheet>
