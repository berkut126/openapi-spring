/**
 * BEST HACK 2020 (web)
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 */

import ApiClient from "../ApiClient.js";
import Body2 from '../model/Body2.js';
import Body3 from '../model/Body3.js';
import InlineResponse200 from '../model/InlineResponse200.js';
import InlineResponse2001 from '../model/InlineResponse2001.js';
import InlineResponse2002 from '../model/InlineResponse2002.js';

/**
* Default service.
* @module api/DefaultApi
* @version 0.0.3
*/
export default class DefaultApi {

    /**
    * Constructs a new DefaultApi. 
    * @alias module:api/DefaultApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instance} if unspecified.
    */
    constructor(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;
    }

    /**
     * Callback function to receive the result of the algoCodeLoginGet operation.
     * @callback module:api/DefaultApi~algoCodeLoginGetCallback
     * @param {String} error Error message, if any.
     * @param {Array.<'String'>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * list of files
     * @param {module:api/DefaultApi~algoCodeLoginGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<'String'>}
     */
    algoCodeLoginGet(login, callback) {
      let postBody = null;

      let pathParams = {
        'login': login
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = ['String'];

      return this.apiClient.callApi(
        '/algoCode/{login}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the algoCodePost operation.
     * @callback module:api/DefaultApi~algoCodePostCallback
     * @param {String} error Error message, if any.
     * @param {'String'} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * upload file
     * @param {module:api/DefaultApi~algoCodePostCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link 'String'}
     */
    algoCodePost(fileName, callback) {
      let postBody = null;

      let pathParams = {
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
        'fileName': fileName
      };

      let authNames = [];
      let contentTypes = ['multipart/form-data'];
      let accepts = ['text/plain'];
      let returnType = 'String';

      return this.apiClient.callApi(
        '/algoCode', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the algoCodeUUIDCodeGet operation.
     * @callback module:api/DefaultApi~algoCodeUUIDCodeGetCallback
     * @param {String} error Error message, if any.
     * @param {'String'} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * returns the code
     * @param {module:api/DefaultApi~algoCodeUUIDCodeGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link 'String'}
     */
    algoCodeUUIDCodeGet(UUID, callback) {
      let postBody = null;

      let pathParams = {
        'UUID': UUID
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['text/plain'];
      let returnType = 'String';

      return this.apiClient.callApi(
        '/algoCode/{UUID}/code', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the algoCodeUUIDDelete operation.
     * @callback module:api/DefaultApi~algoCodeUUIDDeleteCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * delete code
     * @param {module:api/DefaultApi~algoCodeUUIDDeleteCallback} callback The callback function, accepting three arguments: error, data, response
     */
    algoCodeUUIDDelete(UUID, callback) {
      let postBody = null;

      let pathParams = {
        'UUID': UUID
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = [];
      let returnType = null;

      return this.apiClient.callApi(
        '/algoCode/{UUID}', 'DELETE',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the algoCodeUUIDStatusGet operation.
     * @callback module:api/DefaultApi~algoCodeUUIDStatusGetCallback
     * @param {String} error Error message, if any.
     * @param {module:model/InlineResponse200} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * code status
     * @param {module:api/DefaultApi~algoCodeUUIDStatusGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/InlineResponse200}
     */
    algoCodeUUIDStatusGet(UUID, callback) {
      let postBody = null;

      let pathParams = {
        'UUID': UUID
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = InlineResponse200;

      return this.apiClient.callApi(
        '/algoCode/{UUID}/status', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the userGet operation.
     * @callback module:api/DefaultApi~userGetCallback
     * @param {String} error Error message, if any.
     * @param {Array.<'String'>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * list of all user logins
     * @param {module:api/DefaultApi~userGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<'String'>}
     */
    userGet(callback) {
      let postBody = null;

      let pathParams = {
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = ['String'];

      return this.apiClient.callApi(
        '/user', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the userLoginDelete operation.
     * @callback module:api/DefaultApi~userLoginDeleteCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * delete user
     * @param {module:api/DefaultApi~userLoginDeleteCallback} callback The callback function, accepting three arguments: error, data, response
     */
    userLoginDelete(login, callback) {
      let postBody = null;

      let pathParams = {
        'login': login
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = [];
      let returnType = null;

      return this.apiClient.callApi(
        '/user/{login}', 'DELETE',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the userLoginGet operation.
     * @callback module:api/DefaultApi~userLoginGetCallback
     * @param {String} error Error message, if any.
     * @param {module:model/InlineResponse2001} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * user object
     * @param {module:api/DefaultApi~userLoginGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/InlineResponse2001}
     */
    userLoginGet(login, callback) {
      let postBody = null;

      let pathParams = {
        'login': login
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = InlineResponse2001;

      return this.apiClient.callApi(
        '/user/{login}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the userLoginPut operation.
     * @callback module:api/DefaultApi~userLoginPutCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * update user
     * @param {module:api/DefaultApi~userLoginPutCallback} callback The callback function, accepting three arguments: error, data, response
     */
    userLoginPut(body, login, callback) {
      let postBody = body;

      let pathParams = {
        'login': login
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = ['application/x-www-urlencoded'];
      let accepts = [];
      let returnType = null;

      return this.apiClient.callApi(
        '/user/{login}', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the userLoginRolesGet operation.
     * @callback module:api/DefaultApi~userLoginRolesGetCallback
     * @param {String} error Error message, if any.
     * @param {Array.<'String'>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * get user roles
     * @param {module:api/DefaultApi~userLoginRolesGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link Array.<'String'>}
     */
    userLoginRolesGet(login, callback) {
      let postBody = null;

      let pathParams = {
        'login': login
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = ['String'];

      return this.apiClient.callApi(
        '/user/{login}/roles', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the userLoginRolesPut operation.
     * @callback module:api/DefaultApi~userLoginRolesPutCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * update user roles
     * @param {module:api/DefaultApi~userLoginRolesPutCallback} callback The callback function, accepting three arguments: error, data, response
     */
    userLoginRolesPut(body, login, callback) {
      let postBody = body;

      let pathParams = {
        'login': login
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = ['application/x-www-urlencoded'];
      let accepts = [];
      let returnType = null;

      return this.apiClient.callApi(
        '/user/{login}/roles', 'PUT',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the userLoginStatusGet operation.
     * @callback module:api/DefaultApi~userLoginStatusGetCallback
     * @param {String} error Error message, if any.
     * @param {module:model/InlineResponse2002} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * user status
     * @param {module:api/DefaultApi~userLoginStatusGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/InlineResponse2002}
     */
    userLoginStatusGet(login, callback) {
      let postBody = null;

      let pathParams = {
        'login': login
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
      };

      let authNames = [];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = InlineResponse2002;

      return this.apiClient.callApi(
        '/user/{login}/status', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the userPost operation.
     * @callback module:api/DefaultApi~userPostCallback
     * @param {String} error Error message, if any.
     * @param data This operation does not return a value.
     * @param {String} response The complete HTTP response.
     */

    /**
     * create new user
     * @param {module:api/DefaultApi~userPostCallback} callback The callback function, accepting three arguments: error, data, response
     */
    userPost(login, password, callback) {
      let postBody = null;

      let pathParams = {
      };
      let queryParams = {
      };
      let headerParams = {
      };
      let formParams = {
        'login': login,
        'password': password
      };

      let authNames = [];
      let contentTypes = ['application/x-www-form-urlencoded'];
      let accepts = [];
      let returnType = null;

      return this.apiClient.callApi(
        '/user', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

}
