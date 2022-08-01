aaa = function (t, e){
    var n = {
        yyyy: "getFullYear", yy: function (t) {
            return ("" + t.getFullYear()).slice(2)
        }, y: "yy", MM: function (t) {
            var e = t.getMonth() + 1;
            return 10 > e ? "0" + e : e
        }, M: function (t) {
            return t.getMonth() + 1
        }, dd: function (t) {
            var e = t.getDate();
            return 10 > e ? "0" + e : e
        }, d: "getDate", HH: function (t) {
            var e = t.getHours();
            return 10 > e ? "0" + e : e
        }, H: "getHours", hh: function (t) {
            var e = t.getHours() % 12;
            return 10 > e ? "0" + e : e
        }, h: function (t) {
            return t.getHours() % 12
        }, mm: function (t) {
            var e = t.getMinutes();
            return 10 > e ? "0" + e : e
        }, m: "getMinutes", ss: function (t) {
            var e = t.getSeconds();
            return 10 > e ? "0" + e : e
        }, s: "getSeconds", SS: function (t) {
            var e = t.getMilliseconds();
            return 10 > e && "00" + e || 100 > e && "0" + e || e
        }, S: "getMilliseconds", A: function (t) {
            return t.getHours() < 12 ? "AM" : "PM"
        }, a: function (t) {
            return t.getHours() < 12 ? "am" : "pm"
        }, T: "getTime"
    };
    return {
        _patternLetters: n, _rformat: new RegExp(function () {
            var t = [];
            for (var e in n) t.push(e);
            return "(" + t.join("|") + ")"
        }(), "g"), _formatDate: function (t, e) {
            return e.replace(this._rformat, function r(e, a) {
                return "function" == typeof n[a] ? n[a](t) : n[a] in n ? r(e, n[a]) : t[n[a]]()
            })
        }, _randomDate: function (t, e) {
            return t = void 0 === t ? new Date(0) : t, e = void 0 === e ? new Date : e, new Date(Math.random() * (e.getTime() - t.getTime()))
        }, date: function (t) {
            return t = t || "yyyy-MM-dd", this._formatDate(this._randomDate(), t)
        }, time: function (t) {
            return t = t || "HH:mm:ss", this._formatDate(this._randomDate(), t)
        }, datetime: function (t) {
            return t = t || "yyyy-MM-dd HH:mm:ss", this._formatDate(this._randomDate(), t)
        }, now: function (t, e) {
            1 === arguments.length && (/year|month|day|hour|minute|second|week/.test(t) || (e = t, t = "")), t = (t || "").toLowerCase(), e = e || "yyyy-MM-dd HH:mm:ss";
            var n = new Date;
            switch (t) {
                case"year":
                    n.setMonth(0);
                case"month":
                    n.setDate(1);
                case"week":
                case"day":
                    n.setHours(0);
                case"hour":
                    n.setMinutes(0);
                case"minute":
                    n.setSeconds(0);
                case"second":
                    n.setMilliseconds(0)
            }
            switch (t) {
                case"week":
                    n.setDate(n.getDate() - n.getDay())
            }
            return this._formatDate(n, e)
        }
    }
}
