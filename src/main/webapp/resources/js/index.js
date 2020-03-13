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

import ApiClient from './ApiClient.js';
import Body from './model/Body.js';
import Body1 from './model/Body1.js';
import Body2 from './model/Body2.js';
import Body3 from './model/Body3.js';
import InlineResponse200 from './model/InlineResponse200.js';
import InlineResponse2001 from './model/InlineResponse2001.js';
import InlineResponse2002 from './model/InlineResponse2002.js';
import OneOfinlineResponse200 from './model/OneOfinlineResponse200.js';
import DefaultApi from './api/DefaultApi';

/**
* Object.<br>
* The <code>index</code> module provides access to constructors for all the classes which comprise the public API.
* <p>
* An AMD (recommended!) or CommonJS application will generally do something equivalent to the following:
* <pre>
* var BestHack2020Web = require('index'); // See note below*.
* var xxxSvc = new BestHack2020Web.XxxApi(); // Allocate the API class we're going to use.
* var yyyModel = new BestHack2020Web.Yyy(); // Construct a model instance.
* yyyModel.someProperty = 'someValue';
* ...
* var zzz = xxxSvc.doSomething(yyyModel); // Invoke the service.
* ...
* </pre>
* <em>*NOTE: For a top-level AMD script, use require(['index'], function(){...})
* and put the application logic within the callback function.</em>
* </p>
* <p>
* A non-AMD browser application (discouraged) might do something like this:
* <pre>
* var xxxSvc = new BestHack2020Web.XxxApi(); // Allocate the API class we're going to use.
* var yyy = new BestHack2020Web.Yyy(); // Construct a model instance.
* yyyModel.someProperty = 'someValue';
* ...
* var zzz = xxxSvc.doSomething(yyyModel); // Invoke the service.
* ...
* </pre>
* </p>
* @module index
* @version 0.0.3
*/
export {
    /**
     * The ApiClient constructor.
     * @property {module:ApiClient}
     */
    ApiClient,

    /**
     * The Body model constructor.
     * @property {module:model/Body}
     */
    Body,

    /**
     * The Body1 model constructor.
     * @property {module:model/Body1}
     */
    Body1,

    /**
     * The Body2 model constructor.
     * @property {module:model/Body2}
     */
    Body2,

    /**
     * The Body3 model constructor.
     * @property {module:model/Body3}
     */
    Body3,

    /**
     * The InlineResponse200 model constructor.
     * @property {module:model/InlineResponse200}
     */
    InlineResponse200,

    /**
     * The InlineResponse2001 model constructor.
     * @property {module:model/InlineResponse2001}
     */
    InlineResponse2001,

    /**
     * The InlineResponse2002 model constructor.
     * @property {module:model/InlineResponse2002}
     */
    InlineResponse2002,

    /**
     * The OneOfinlineResponse200 model constructor.
     * @property {module:model/OneOfinlineResponse200}
     */
    OneOfinlineResponse200,

    /**
    * The DefaultApi service constructor.
    * @property {module:api/DefaultApi}
    */
    DefaultApi
};
