"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.KySu = void 0;
var CanBo_1 = require("./CanBo");
var KySu = /** @class */ (function (_super) {
    __extends(KySu, _super);
    function KySu(name, age, gender, address, specialized) {
        var _this = _super.call(this, name, age, gender, address) || this;
        _this.specialized = specialized;
        return _this;
    }
    KySu.prototype.printInforKysu = function () {
        console.log("Thông tin Kỹ Sư");
        _super.prototype.printInforCanBo.call(this);
        console.log("Specialized: " + this.specialized);
    };
    return KySu;
}(CanBo_1.CanBo));
exports.KySu = KySu;
