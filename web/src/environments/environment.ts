
export const environment = {
	production: false,

	server: false,
	local: true,
	envName: 'loc',
	urlbackend: 'http://localhost',
	port: '8081',
	contextPath: 'imposto-api/',
	urlbackendheroku: 'https://sgm-backend-pucminas.herokuapp.com',
	useheroky: true,

	/*LOCAL */
	// keycloak: {
	// 	url_keycloack: 'http://localhost:8080/auth/',
	// 	realm: 'SGM',
	// 	clientId: 'sgm-ui',
	// }
	
	/*HEROKU */
	  keycloak: {
		url_keycloack: 'https://sgm-keycloak-pucminas.herokuapp.com/auth/',
		realm: 'SGM',
		clientId: 'sgm-ui',
	}
};
