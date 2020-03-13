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

import ApiClient from '../ApiClient.js';

/**
* The Body model module.
* @module model/Body
* @version 0.0.3
*/
export default class Body {
    /**
    * Constructs a new <code>Body</code>.
    * @alias module:model/Body
    * @class
    */

    constructor() {
        
        
        
    }

    /**
    * Constructs a <code>Body</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/Body} obj Optional instance to populate.
    * @return {module:model/Body} The populated <code>Body</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Body();
                        
            
            if (data.hasOwnProperty('fileName')) {
                obj['fileName'] = ApiClient.convertToType(data['fileName'], 'Blob');
            }
        }
        return obj;
    }

    /**
    * @member {Blob} fileName
    */
    fileName = undefined;




}