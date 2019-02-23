CREATE TABLE IF NOT EXISTS oauth_client_details (
  client_id varchar(255),
  resource_ids varchar(255),
  client_secret varchar(255),
  scope varchar(255),
  authorized_grant_types varchar(255),
  web_server_redirect_uri varchar(255),
  authorities varchar(255),
  access_token_validity integer,
  refresh_token_validity integer,
  additional_information varchar(4096),
  autoapprove varchar(255),
  primary key (client_id)
);

CREATE TABLE IF NOT EXISTS oauth_client_token (
  token_id varchar(255),
  token varchar(255),
  authentication_id varchar(255),
  user_name varchar(255),
  client_id varchar(255),
  primary key (authentication_id)
);

CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id varchar(255),
  token BLOB,
  authentication_id varchar(255),
  user_name varchar(255),
  client_id varchar(255),
  authentication BLOB,
  refresh_token varchar(255),
  primary key (authentication_id)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id varchar(255),
  token BLOB,
  authentication BLOB
);

CREATE TABLE IF NOT EXISTS oauth_code (
  code varchar(255),
  authentication varchar(255)
);

CREATE TABLE IF NOT EXISTS oauth_approvals (
  userid varchar(255),
  clientid varchar(255),
  scope varchar(255),
  status varchar(10),
  expiresat timestamp null default null,
  lastmodifiedat timestamp null default null
);