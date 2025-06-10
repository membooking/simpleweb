CREATE SCHEMA lppage;
CREATE TABLE lppage.themepage
(
    themepageid bigserial NOT NULL,
    theme character varying(127) NOT NULL,
    code character varying(255) NOT NULL,
    content text,
    jcomponent text,
    status integer default 1,
    lastupdate timestamp without time zone,
    CONSTRAINT themepage_pkey PRIMARY KEY (themepageid)
);
CREATE TABLE lppage.themecomponent
(
    themecomponentid bigserial NOT NULL,
    theme character varying(127) NOT NULL,
    code character varying(255) NOT NULL,
    section character varying(255),
    tags character varying(511),
    content text,
    jdata text,
    status integer default 1,
    lastupdate timestamp without time zone,
    CONSTRAINT themecomponent_pkey PRIMARY KEY (themecomponentid)
);
