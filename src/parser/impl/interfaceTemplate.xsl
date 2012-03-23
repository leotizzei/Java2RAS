<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    <!-- get the name of the class and set the artifacts names -->
    <xsl:template match="/">
        <asset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:noNamespaceSchemaLocation="file:/home/lsd/ra001973/mestrado/verificador/desenvolvimento/interfaceprofile.xsd"
            name="IHotel" id="12345789" state="development">
            <profile name="interfacedefinition">
                <relatedasset/>
                <relatedprofile>
                    <description> </description>
                </relatedprofile>
                <description/>
            </profile>
            <solution>

                <design>
                    <diagram>
                        <artifact>
                            <!-- this tag gets the value of the attribute name from the tag interface and set 
                            the name attribute from artifact-->
                            <xsl:attribute name="name">
                                <xsl:value-of select="descendant::interface/attribute::name"/>
                            </xsl:attribute>
                        </artifact>
                    </diagram>
                    <xsl:apply-templates select="descendant-or-self::interface"/>
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
                <requirements>
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
                    <usecase>
                        <artifact>
                            <artifactcontext/>
                            <artifactdependency/>
                            <artifacttype/>
                            <variabilitypoint/>
                        </artifact>
                    </usecase>
                </requirements>
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

     <!--  get the interface name and set the interfacedefinition name -->
    <xsl:template match="interface">
        <interfacedefinition name="{@name}">
            <xsl:apply-templates/>
        </interfacedefinition>
    </xsl:template>

    <!-- set the operation name, visibility  and return type-->
    <xsl:template match="method">
        <operation name="{@name}" visibility="{@visibility}">
            <xsl:attribute name="returnType">
                <xsl:value-of select="descendant::type/attribute::name"/>
            </xsl:attribute>
            <xsl:apply-templates select="child::formal-arguments/formal-argument"/>
        </operation>
    </xsl:template>

    <!-- set the attribute name, value, type and visibility -->
    <xsl:template match="field">
        <informationmodel>
            <attribute name="{@name}">
                <xsl:attribute name="type">
                    <xsl:value-of select="child::type/attribute::name"/>
                </xsl:attribute>
                <xsl:attribute name="defaultvalue">
                    <xsl:value-of select="child::literal-number/attribute::value"/>
                </xsl:attribute>
                <xsl:attribute name="visibility">
                    <xsl:value-of select="attribute::visibility"/>
                </xsl:attribute>
            </attribute>
            <associationrole/>
        </informationmodel>
    </xsl:template>

    
    <!-- set the parameter name, type and positiion -->
    <xsl:template match="formal-argument">
        <parameter name="{@name}">
            <xsl:attribute name="type">
                <xsl:apply-templates select="descendant-or-self::type"/>
            </xsl:attribute>
            <xsl:attribute name="position">
                <xsl:value-of select="position()"/>
            </xsl:attribute>
        </parameter>
    </xsl:template>

     <!--  get the value of the attribute name of the type element -->
    <xsl:template match="type">
        <xsl:value-of select="@name"/>
    </xsl:template>
</xsl:stylesheet>
