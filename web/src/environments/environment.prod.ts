export const environment = {
  production: true,

  server: false,
	local: true,
	envName: 'loc',
	urlbackend: 'http://localhost',
	port: '8081',
	contextPath: 'imposto-api/',
	urlbackendheroku: 'https://sgm-backend-pucminas.herokuapp.com',
	useheroky: true,

  keycloak: {
		url_keycloack: 'https://sgm-keycloak-pucminas.herokuapp.com/auth/',
		realm: 'SGM',
		clientId: 'sgm-ui',
	}
};
