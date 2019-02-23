/* password default: 123 */

insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity)
 values ('system_admin', 'resource-server-rest-api','$2a$10$12chiasO9PpGeT5f93W3I.6/WuCaatLJSvD9VPY3o1MmnOssgE43O', /* password: admin */
 'read,write,system', 'password,authorization_code,refresh_token,implicit', 'SYSTEM_ADMIN', 10800, 2592000);

insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity)
 values ('customer_read', 'resource-server-rest-api','$2a$10$Ja5eUUt7q1x2RmDIzKpTXu7Pstpg10Dkxwf5f2CRE.lQf8yJyEDFa',
 'read', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);

insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, access_token_validity, refresh_token_validity)
 values ('customer_write', 'resource-server-rest-api','$2a$10$Ja5eUUt7q1x2RmDIzKpTXu7Pstpg10Dkxwf5f2CRE.lQf8yJyEDFa',
 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);