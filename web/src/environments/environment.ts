
export const environment = {
  production: false,

  server: false,
	local: true,
	envName: 'loc',
	urlbackend: 'http://localhost',
	port: '8081',
	contextPath: 'cidadao-api/',

	keycloak: {
		issuer: 'http://localhost:8080/auth/',
		realm: 'SGM',
		clientId: 'sgm-ui',
	  }
};
