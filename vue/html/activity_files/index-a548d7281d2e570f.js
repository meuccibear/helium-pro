(self.webpackChunk_N_E = self.webpackChunk_N_E || []).push([[405], {
  78581: function (e, t, n) {
    (window.__NEXT_P = window.__NEXT_P || []).push(["/", function () {
      return n(57369)
    }])
  }, 57780: function (e, t, n) {
    "use strict";
    n.d(t, {
      ei: function () {
        return d
      }, $x: function () {
        return f
      }, Bb: function () {
        return m
      }, S4: function () {
        return h
      }, T7: function () {
        return p
      }, w: function () {
        return x
      }, xy: function () {
        return v
      }, HW: function () {
        return g
      }, y4: function () {
        return y
      }, Fu: function () {
        return j
      }, yV: function () {
        return w
      }
    });
    var r = n(48403), a = n.n(r), s = n(12828), i = n.n(s), o = n(89947);

    function l(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function c(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function u(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return l(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return l(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var d = 1500, f = function (e) {
      return e.split("-").map(a()).join(" ")
    }, m = function (e) {
      return e < 1e3 ? e.toLocaleString(void 0, {maximumFractionDigits: 2}) + " m" : e < 1e4 ? (e / 1e3).toLocaleString(void 0, {maximumFractionDigits: 1}) + " km" : (e / 1e3).toLocaleString(void 0, {maximumFractionDigits: 0}) + " km"
    }, h = function (e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] && arguments[1], n = i()(e);
      if (!(null === n || void 0 === n ? void 0 : n.shortCountry) && !(null === n || void 0 === n ? void 0 : n.longCountry)) return "No location set";
      var r = [];
      return r.push(t ? null === n || void 0 === n ? void 0 : n.shortCountry : null === n || void 0 === n ? void 0 : n.longCountry), r.join(", ")
    }, p = function (e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] && arguments[1], n = i()(e);
      if (!(null === n || void 0 === n ? void 0 : n.longCity) && !(null === n || void 0 === n ? void 0 : n.shortState) && !(null === n || void 0 === n ? void 0 : n.longCountry)) return "No location set";
      var r = [];
      return (null === n || void 0 === n ? void 0 : n.longCity) && r.push(null === n || void 0 === n ? void 0 : n.longCity), !t && (null === n || void 0 === n ? void 0 : n.shortState) && r.push(null === n || void 0 === n ? void 0 : n.shortState), r.push(t ? null === n || void 0 === n ? void 0 : n.shortCountry : null === n || void 0 === n ? void 0 : n.longCountry), r.join(", ")
    }, x = function (e) {
      var t = 1 / 6;
      return e >= 5 * t ? "#29D344" : e >= 4 * t ? "#9FE14A" : e >= .5 ? "#FCC945" : e >= 2 * t ? "#FEA053" : e >= 1 * t ? "#FC8745" : "#FF6666"
    }, v = function (e) {
      var t = e.locationHex || e.location_hex || (0, o.h3ToParent)(e.location, 8), n = u((0, o.h3ToGeo)(t), 2);
      return function (e) {
        for (var t = 1; t < arguments.length; t++) {
          var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
          "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
            return Object.getOwnPropertyDescriptor(n, e).enumerable
          })))), r.forEach((function (t) {
            c(e, t, n[t])
          }))
        }
        return e
      }({}, e, {location: t, lat: n[0], lng: n[1]})
    }, g = function (e) {
      var t = /ip4/g;
      return !(!(e && e.length > 0) || e.find((function (e) {
        return e.match(t)
      })))
    }, y = function (e) {
      return "".concat(e / 10, " dBi")
    }, j = function (e) {
      return "".concat(e, " m")
    }, w = function (e) {
      return "dataonly" === (null === e || void 0 === e ? void 0 : e.mode)
    }
  }, 75805: function (e, t, n) {
    "use strict";

    function r(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function a(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return r(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return r(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var s = n(89947), i = "Feature", o = "FeatureCollection", l = "Polygon", c = "MultiPolygon";

    function u(e) {
      for (var t = null, n = 0; n < e.length; n++) if (null !== t) for (var r = 0; r < e[n].length; r++) t.push(e[n][r]); else t = e[n];
      return Array.from(new Set(t))
    }

    function d(e) {
      for (var t = 0, n = 0, r = 0, a = e[0], s = 0; s < a.length; s++) t += a[s][0], n += a[s][1], r++;
      return [t / r, n / r]
    }

    function f(e, t) {
      var n = e.features;
      if (!n) throw new Error("No features found");
      return u(n.map((function (e) {
        return m(e, t)
      })))
    }

    function m(e, t) {
      var n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : {}, r = e.type, m = e.geometry,
        h = m && m.type;
      if (r === o) return f(e, t);
      if (r !== i) throw new Error("Unhandled type: ".concat(r));
      if (h !== l && h !== c) throw new Error("Unhandled geometry type: ".concat(h));
      var p = h === l ? [m.coordinates] : m.coordinates;
      return u(p.map((function (e) {
        var r = s.polyfill(e, t, !0);
        if (r.length || !n.ensureOutput) return r;
        var i = a(d(e), 2), o = i[0], l = i[1];
        return [s.geoToH3(l, o, t)]
      })))
    }

    function h(e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {}, n = [s.h3ToGeoBoundary(e, !0)];
      return {type: i, id: e, properties: t, geometry: {type: l, coordinates: n}}
    }

    e.exports = {
      featureToH3Set: m, h3ToFeature: h, h3SetToFeature: function (e) {
        var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {}, n = s.h3SetToMultiPolygon(e, !0),
          r = n.length > 1, a = r ? c : l, o = r ? n : n[0] || [];
        return {type: i, properties: t, geometry: {type: a, coordinates: o}}
      }, h3SetToMultiPolygonFeature: function (e) {
        var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {}, n = e.map((function (e) {
          return [s.h3ToGeoBoundary(e, {geoJson: !0})]
        }));
        return {type: i, properties: t, geometry: {type: c, coordinates: n}}
      }, h3SetToFeatureCollection: function (e, t) {
        for (var n = [], r = 0; r < e.length; r++) {
          var a = e[r], s = t ? t(a) : {};
          n.push(h(a, s))
        }
        return {type: o, features: n}
      }
    }
  }, 47873: function (e, t, n) {
    "use strict";
    n.d(t, {
      pA: function () {
        return i
      }, IB: function () {
        return o
      }
    });
    var r = n(42473), a = n.n(r), s = n(83454), i = 1e5, o = s.env.NEXT_PUBLIC_NETWORK || "mainnet",
      l = new (a())("testnet" === o ? r.Network.testnet : new r.Network({
        baseURL: "https://ugxlyxnlrg9udfdyzwnrvghlu2vydmvycg.blockjoy.com",
        version: 1
      }), {retry: 3});
    t.ZP = l
  }, 3013: function (e, t, n) {
    "use strict";
    n.d(t, {
      id: function () {
        return y
      }, Nl: function () {
        return j
      }, jt: function () {
        return w
      }, Fc: function () {
        return b
      }, ex: function () {
        return k
      }, qi: function () {
        return N
      }, XL: function () {
        return S
      }, vy: function () {
        return C
      }
    });
    var r = n(34051), a = n.n(r), s = n(67294), i = n(52572), o = n(89947), l = n(8100), c = n(47873), u = n(14361),
      d = n(57780);

    function f(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function m(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function h(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            m(s, r, a, i, o, "next", e)
          }

          function o(e) {
            m(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function p(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function x(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          p(e, t, n[t])
        }))
      }
      return e
    }

    function v(e) {
      return function (e) {
        if (Array.isArray(e)) return f(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return f(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return f(e, t)
      }(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var g = function () {
      var e = h(a().mark((function e() {
        var t, n, r = arguments;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return t = r.length > 0 && void 0 !== r[0] ? r[0] : 20, e.next = 3, c.ZP.hotspots.list();
            case 3:
              return e.next = 5, e.sent.take(t);
            case 5:
              return n = e.sent, e.abrupt("return", JSON.parse(JSON.stringify(n)));
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function () {
        return e.apply(this, arguments)
      }
    }(), y = function (e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 20, n = function () {
        return g(t)
      }, r = (0, l.ZP)("latestHotspots", n, {initialData: e, refreshInterval: 6e4}), a = r.data, s = r.error;
      return {latestHotspots: a, isLoading: !s && !a, isError: s}
    }, j = function () {
      var e = h(a().mark((function e(t) {
        var n, r;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.prev = 0, e.next = 3, fetch("https://denylist-api.herokuapp.com/api/hotspots/".concat(t));
            case 3:
              return e.next = 5, e.sent.json();
            case 5:
              return n = e.sent, r = n.denylists, e.abrupt("return", r);
            case 10:
              return e.prev = 10, e.t0 = e.catch(0), console.error(e.t0), e.abrupt("return", null);
            case 14:
            case"end":
              return e.stop()
          }
        }), e, null, [[0, 10]])
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), w = (function () {
      var e = h(a().mark((function e(t, n) {
        var r, s;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return r = new Date, (s = new Date).setDate(r.getDate() - n), e.abrupt("return", c.ZP.hotspot(t).rewards.sum.get(s, r));
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })))
    }(), function () {
      var e = h(a().mark((function e(t, n) {
        var r, s, i, l = arguments;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              if (r = l.length > 2 && void 0 !== l[2] ? l[2] : 1e3, t && n) {
                e.next = 3;
                break
              }
              return e.abrupt("return", []);
            case 3:
              return e.next = 5, c.ZP.hotspots.locationDistance({lat: t, lon: n, distance: r});
            case 5:
              return e.next = 7, e.sent.take(c.pA);
            case 7:
              return s = e.sent, i = s.map((function (e) {
                return x({}, e, {distance: 1e3 * (0, u.xm)(n, t, (0, o.h3ToGeo)(e.locationHex)[1], (0, o.h3ToGeo)(e.locationHex)[0])})
              })), e.abrupt("return", i);
            case 10:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t, n) {
        return e.apply(this, arguments)
      }
    }()), b = function () {
      var e = h(a().mark((function e(t) {
        var n, r;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, c.ZP.hotspots.get(t);
            case 2:
              return n = e.sent, r = (0, d.xy)(n), e.abrupt("return", JSON.parse(JSON.stringify(r)));
            case 5:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), k = function () {
      var e = h(a().mark((function e(t) {
        var n, r;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, c.ZP.hotspots.elected(t);
            case 2:
              return n = e.sent, e.next = 5, n.take(c.pA);
            case 5:
              return r = e.sent, e.abrupt("return", r);
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), N = function () {
      var e = h(a().mark((function e(t) {
        var n, r;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, c.ZP.hotspots.hex(t);
            case 2:
              return n = e.sent, e.next = 5, n.take(c.pA);
            case 5:
              return r = e.sent, e.abrupt("return", r);
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), S = function () {
      var e = h(a().mark((function e(t) {
        var n, r;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, c.ZP.hotspot(t).witnessed.list();
            case 2:
              return n = e.sent, e.next = 5, n.take(c.pA);
            case 5:
              return r = e.sent, e.abrupt("return", r);
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), C = function (e, t) {
      var n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 20, r = (0, s.useState)(), o = r[0],
        l = r[1], u = (0, s.useState)([]), d = u[0], f = u[1], m = (0, s.useState)(!0), p = m[0], x = m[1],
        g = (0, s.useState)(!1), y = g[0], j = g[1], w = (0, s.useState)(!0), b = w[0], k = w[1], N = function () {
          var n = h(a().mark((function n() {
            var r;
            return a().wrap((function (n) {
              for (; ;) switch (n.prev = n.next) {
                case 0:
                  if (e && t) {
                    n.next = 2;
                    break
                  }
                  return n.abrupt("return", c.ZP.hotspots.list());
                case 2:
                  if ("account" !== e) {
                    n.next = 4;
                    break
                  }
                  return n.abrupt("return", c.ZP.account(t).hotspots.list());
                case 4:
                  if ("city" !== e) {
                    n.next = 9;
                    break
                  }
                  return n.next = 7, c.ZP.city(t).hotspots.list();
                case 7:
                  return r = n.sent, n.abrupt("return", r);
                case 9:
                case"end":
                  return n.stop()
              }
            }), n)
          })));
          return function () {
            return n.apply(this, arguments)
          }
        }();
      (0, i.r5)(h(a().mark((function e() {
        var t;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, N();
            case 2:
              t = e.sent, l(t);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      }))), []), (0, i.r5)(h(a().mark((function e() {
        var t;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              if (o) {
                e.next = 2;
                break
              }
              return e.abrupt("return");
            case 2:
              return j(!0), e.next = 5, o.take(n);
            case 5:
              t = e.sent, f(t), j(!1), x(!1), t.length < n && k(!1);
            case 10:
            case"end":
              return e.stop()
          }
        }), e)
      }))), [o]);
      var S = (0, s.useCallback)(h(a().mark((function e() {
        var t;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, o.take(n);
            case 2:
              t = e.sent, f(v(d).concat(v(t)));
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      }))), [o, n, d]);
      return {hotspots: d, fetchMore: S, isLoadingInitial: p, isLoadingMore: y, hasMore: b}
    }
  }, 82646: function (e, t, n) {
    "use strict";
    n.d(t, {
      Pr: function () {
        return m
      }, Pl: function () {
        return h
      }
    });
    var r = n(34051), a = n.n(r), s = (n(85893), n(67294), {
      state_channel_close_v1: {color: "teal", name: "Packets Transferred"},
      payment_v1: {color: "green", name: "Payment"},
      payment_v2: {color: "cyan", name: "Payment"},
      poc_request_v1: {color: "#29D391", name: "PoC Challenger", tooltip: "Proof of Coverage Challenge"},
      poc_receipts_v1: {color: "#38A2FF", name: "PoC Receipt", tooltip: "Proof of Coverage Receipt"},
      rewards_v1: {color: "#E68B00", name: "Mining Reward", tooltip: "Mining Reward (v1)"},
      rewards_v2: {color: "#E68B00", name: "Mining Reward", tooltip: "Mining Reward (v2)"},
      rewards_v3: {color: "#E68B00", name: "Mining Reward", tooltip: "Mining Reward (v3)"},
      consensus_group_v1: {color: "#FF6666", name: "Consensus Election", tooltip: "Consensus Election"},
      transfer_hotspot_v1: {
        color: "#474DFF",
        name: "Transfer Hotspot",
        tooltip: "Hotspot Transfer Confirmation Transaction"
      },
      poc_challengers: {color: "#BE73FF", name: "Challenger", tooltip: "PoC challenger"},
      poc_challengees: {color: "#595A9A", name: "Beacon", tooltip: "PoC challengee"},
      assert_location_v1: {color: "#16CEE8", name: "Assert Location", tooltip: "Assert Location Transaction (v1)"},
      assert_location_v2: {color: "#16CEE8", name: "Assert Location", tooltip: "Assert Location Transaction (v2)"},
      add_gateway_v1: {color: "#8597BB", name: "Add Hotspot", tooltip: "Add Gateway Transaction"},
      poc_witnesses: {color: "#FFC769", name: "Witness", tooltip: "PoC witness"},
      poc_witnesses_valid: {color: "#FFC769", name: "Witness", tooltip: "PoC witness (Valid)"},
      poc_witnesses_invalid: {color: "#717E98", name: "Witness", tooltip: "PoC witness (Invalid)"},
      securities: {
        color: "#9AE8C9",
        name: "Security Token Reward",
        tooltip: "Mining Reward for Security Token holders"
      },
      token_burn_v1: {color: "#E86161", name: "Token Burn"},
      default: {color: "blue"}
    }), i = function (e) {
      var t;
      return (null === (t = s[e]) || void 0 === t ? void 0 : t.name) || e
    }, o = function (e) {
      return (s[e] || s.default).color
    }, l = function (e) {
      var t;
      return null === (t = s[e]) || void 0 === t ? void 0 : t.tooltip
    }, c = n(47873);

    function u(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function d(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function f(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          d(e, t, n[t])
        }))
      }
      return e
    }

    var m = function () {
      var e, t = (e = a().mark((function e(t) {
        var n, r, s, u, d = arguments;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return n = d.length > 1 && void 0 !== d[1] ? d[1] : {}, r = {}, e.prev = 2, e.next = 5, c.ZP.transactions.get(t, n);
            case 5:
              if ((r = e.sent).name = i(r.type), r.color = o(r.type), r.tooltip = l(r.type), !r.location) {
                e.next = 14;
                break
              }
              return e.next = 12, c.ZP.locations.get(r.location);
            case 12:
              s = e.sent, r.geocode = s;
            case 14:
              e.next = 19;
              break;
            case 16:
              e.prev = 16, e.t0 = e.catch(2), console.error(e.t0);
            case 19:
              return u = p(r), e.abrupt("return", u);
            case 21:
            case"end":
              return e.stop()
          }
        }), e, null, [[2, 16]])
      })), function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            u(s, r, a, i, o, "next", e)
          }

          function o(e) {
            u(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      });
      return function (e) {
        return t.apply(this, arguments)
      }
    }(), h = function (e) {
      return e.map((function (e) {
        if ("poc_receipts_v1" === e.type) {
          var t, n, r,
            a = null === (t = e.path) || void 0 === t || null === (n = t[0]) || void 0 === n ? void 0 : n.witnesses,
            s = null === a || void 0 === a ? void 0 : a.length,
            i = null === (r = null === a || void 0 === a ? void 0 : a.filter((function (e) {
              return e.isValid
            }))) || void 0 === r ? void 0 : r.length;
          return f({}, e, {numberOfValidWitnesses: i, numberOfInvalidWitnesses: s - i})
        }
        return e
      }))
    }, p = function (e) {
      switch (e.type) {
        case"poc_receipts_v1":
        case"poc_receipts_v2":
          var t, n, r,
            a = null === (t = e.path) || void 0 === t || null === (n = t[0]) || void 0 === n ? void 0 : n.witnesses,
            s = null === a || void 0 === a ? void 0 : a.length,
            i = null === (r = null === a || void 0 === a ? void 0 : a.filter((function (e) {
              return e.isValid
            }))) || void 0 === r ? void 0 : r.length;
          return f({}, e, {numberOfValidWitnesses: i, numberOfInvalidWitnesses: s - i});
        default:
          return e
      }
    }
  }, 93843: function (e, t, n) {
    "use strict";
    n.d(t, {
      a8: function () {
        return m
      }
    });
    var r = n(34051), a = n.n(r), s = n(8100), i = n(47873);

    function o(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function l(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            o(s, r, a, i, l, "next", e)
          }

          function l(e) {
            o(s, r, a, i, l, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function c(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function u(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          c(e, t, n[t])
        }))
      }
      return e
    }

    var d = {v1: "https://explorer-api.helium.com/api", v2: "https://explorer-api-v2.helium.com/api"},
      f = "https://helium-testnet-explorer-api.herokuapp.com/api", m = function () {
        var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : "v1";
        return function () {
          var t = l(a().mark((function t(n) {
            var r, s, o;
            return a().wrap((function (t) {
              for (; ;) switch (t.prev = t.next) {
                case 0:
                  return r = "testnet" === i.IB ? f : d[e], s = [r, n].join(""), t.next = 4, fetch(s, {headers: {"cache-control": "max-age=60"}});
                case 4:
                  return o = t.sent, t.abrupt("return", o.json());
                case 6:
                case"end":
                  return t.stop()
              }
            }), t)
          })));
          return function (e) {
            return t.apply(this, arguments)
          }
        }()
      };
    t.ZP = function (e) {
      var t, n = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {},
        r = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : {localCache: !0, version: "v1"};
      if (r.localCache) {
        var a = localStorage.getItem(e);
        a && (t = JSON.parse(a))
      }
      return (0, s.ZP)(e, m(r.version), u({
        initialData: t, revalidateOnMount: !0, onFailure: function () {
          r.localCache && localStorage.removeItem(e)
        }, onSuccess: function (t) {
          r.localCache && localStorage.setItem(e, JSON.stringify(t))
        }
      }, n))
    }
  }, 49946: function (e, t, n) {
    "use strict";
    var r = n(67294), a = n(80537), s = n(67014);
    t.Z = function () {
      var e = (0, s.Z)();
      return {
        showInfoBox: (0, r.useContext)(a.h).state.showInfoBox, toggleInfoBox: (0, r.useCallback)((function () {
          e({type: a.xs})
        }), [e])
      }
    }
  }, 59974: function (e, t, n) {
    "use strict";
    var r = n(67294), a = n(80537), s = n(67014);
    t.Z = function () {
      var e = (0, s.Z)(), t = (0, r.useContext)(a.h).state, n = t.showMapLayers, i = t.mapLayer;
      return {
        showMapLayers: n, toggleMapLayers: (0, r.useCallback)((function () {
          e({type: a.UO})
        }), [e]), setMapLayer: (0, r.useCallback)((function (t) {
          e({type: a.dR, payload: t})
        }), [e]), mapLayer: i
      }
    }
  }, 67038: function (e, t, n) {
    "use strict";
    var r = n(34051), a = n.n(r), s = n(67294), i = n(80537), o = n(67014), l = n(93843), c = n(80129), u = n.n(c),
      d = n(76775);

    function f(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function m(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function h(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          m(e, t, n[t])
        }))
      }
      return e
    }

    t.Z = function () {
      var e = (0, o.Z)(), t = (0, d.k6)(), n = (0, s.useContext)(i.h).state.selectedCity,
        r = (0, s.useCallback)(function () {
          var n, r = (n = a().mark((function n(r) {
            var s;
            return a().wrap((function (n) {
              for (; ;) switch (n.prev = n.next) {
                case 0:
                  return n.next = 2, (0, l.a8)("v1")("/cities/search?" + u().stringify({term: [r.longCity, r.longState, r.longCountry].join(", ")}));
                case 2:
                  s = n.sent, e({
                    type: i.mI,
                    payload: h({}, r, {geometry: s})
                  }), t.push("/hotspots/cities/".concat(r.cityId));
                case 5:
                case"end":
                  return n.stop()
              }
            }), n)
          })), function () {
            var e = this, t = arguments;
            return new Promise((function (r, a) {
              var s = n.apply(e, t);

              function i(e) {
                f(s, r, a, i, o, "next", e)
              }

              function o(e) {
                f(s, r, a, i, o, "throw", e)
              }

              i(void 0)
            }))
          });
          return function (e) {
            return r.apply(this, arguments)
          }
        }(), [e, t]);
      return {
        selectedCity: n, selectCity: r, clearSelectedCity: (0, s.useCallback)((function () {
          e({type: i.mI, payload: null})
        }), [e])
      }
    }
  }, 81034: function (e, t, n) {
    "use strict";
    var r = n(34051), a = n.n(r), s = n(67294), i = n(76775), o = n(72895), l = n(89947), c = n(80537), u = n(67014);

    function d(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function f(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function m(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          f(e, t, n[t])
        }))
      }
      return e
    }

    t.Z = function () {
      var e = (0, u.Z)(), t = (0, i.k6)(), n = (0, s.useContext)(c.h).state.selectedHex,
        r = (0, s.useCallback)(function () {
          var n, r = (n = a().mark((function n(r) {
            var s;
            return a().wrap((function (n) {
              for (; ;) switch (n.prev = n.next) {
                case 0:
                  s = {
                    index: r,
                    feature: (0, o.h3SetToFeatureCollection)([r]),
                    center: (0, l.h3ToGeo)(r)
                  }, e({type: c.v$, payload: m({}, s)}), t.push("/hotspots/hex/".concat(r));
                case 3:
                case"end":
                  return n.stop()
              }
            }), n)
          })), function () {
            var e = this, t = arguments;
            return new Promise((function (r, a) {
              var s = n.apply(e, t);

              function i(e) {
                d(s, r, a, i, o, "next", e)
              }

              function o(e) {
                d(s, r, a, i, o, "throw", e)
              }

              i(void 0)
            }))
          });
          return function (e) {
            return r.apply(this, arguments)
          }
        }(), [e, t]);
      return {
        selectedHex: n, selectHex: r, clearSelectedHex: (0, s.useCallback)((function () {
          e({type: c.v$, payload: null})
        }), [e])
      }
    }
  }, 14184: function (e, t, n) {
    "use strict";
    var r = n(34051), a = n.n(r), s = n(67294), i = n(57780), o = n(47873), l = n(3013), c = n(80537), u = n(67014),
      d = n(14361);

    function f(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function m(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            f(s, r, a, i, o, "next", e)
          }

          function o(e) {
            f(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function h(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function p(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          h(e, t, n[t])
        }))
      }
      return e
    }

    function x(e) {
      return v.apply(this, arguments)
    }

    function v() {
      return (v = m(a().mark((function e(t) {
        var n, r;
        return a().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, o.ZP.hotspot(t).witnessed.list();
            case 2:
              return n = e.sent, e.next = 5, n.take(o.pA);
            case 5:
              return r = e.sent, e.abrupt("return", r.filter((function (e) {
                return !(e.address === t)
              })));
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })))).apply(this, arguments)
    }

    t.Z = function () {
      var e = (0, u.Z)(), t = (0, s.useState)([]), n = t[0], r = t[1], o = (0, s.useContext)(c.h).state.selectedHotspot,
        f = (0, s.useCallback)(function () {
          var t = m(a().mark((function t(s) {
            var o, u, f, m, h;
            return a().wrap((function (t) {
              for (; ;) switch (t.prev = t.next) {
                case 0:
                  return t.next = 2, (0, l.Fc)(s);
                case 2:
                  return o = t.sent, u = [], t.prev = 4, t.next = 7, x(s);
                case 7:
                  f = t.sent, u = f, t.next = 17;
                  break;
                case 11:
                  t.prev = 11, t.t0 = t.catch(4), console.error(t.t0), (m = n).push(t.t0), r(m);
                case 17:
                  h = u.filter((function (e) {
                    return (0, d.xm)(null === o || void 0 === o ? void 0 : o.lng, null === o || void 0 === o ? void 0 : o.lat, e.lng, e.lat) <= 200
                  })).map(i.xy), e({type: c.xp, payload: p({}, o, {witnessed: h, errors: n})});
                case 19:
                case"end":
                  return t.stop()
              }
            }), t, null, [[4, 11]])
          })));
          return function (e) {
            return t.apply(this, arguments)
          }
        }(), [e, n]);
      return {
        selectedHotspot: o, selectHotspot: f, clearSelectedHotspot: (0, s.useCallback)((function () {
          e({type: c.xp, payload: null})
        }), [e])
      }
    }
  }, 38864: function (e, t, n) {
    "use strict";
    var r = n(34051), a = n.n(r), s = n(67294), i = n(82646), o = n(80537), l = n(67014);

    function c(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function u(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function d(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          u(e, t, n[t])
        }))
      }
      return e
    }

    t.Z = function () {
      var e = (0, l.Z)(), t = (0, s.useContext)(o.h).state.selectedTxn, n = (0, s.useCallback)(function () {
        var t, n = (t = a().mark((function t(n) {
          var r;
          return a().wrap((function (t) {
            for (; ;) switch (t.prev = t.next) {
              case 0:
                return t.next = 2, (0, i.Pr)(n);
              case 2:
                r = t.sent, e({type: o.yW, payload: d({}, r)});
              case 4:
              case"end":
                return t.stop()
            }
          }), t)
        })), function () {
          var e = this, n = arguments;
          return new Promise((function (r, a) {
            var s = t.apply(e, n);

            function i(e) {
              c(s, r, a, i, o, "next", e)
            }

            function o(e) {
              c(s, r, a, i, o, "throw", e)
            }

            i(void 0)
          }))
        });
        return function (e) {
          return n.apply(this, arguments)
        }
      }(), [e]);
      return {
        selectedTxn: t, selectTxn: n, clearSelectedTxn: (0, s.useCallback)((function () {
          e({type: o.yW, payload: null})
        }), [e])
      }
    }
  }, 57369: function (e, t, n) {
    "use strict";
    n.r(t), n.d(t, {
      Index: function () {
        return wl
      }, default: function () {
        return bl
      }
    });
    var r = n(85893), a = n(67294), s = n(5152), i = n(76775), o = n(6612), l = n(25675), c = n(96486), u = n(4340),
      d = n(34051), f = n.n(d), m = n(47873), h = n(26938), p = n(19302), x = n(74221);

    function v(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function g(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function y(e) {
      return function (e) {
        if (Array.isArray(e)) return v(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return v(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return v(e, t)
      }(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var j = "CLEAR_RESULTS", w = "PUSH_RESULTS", b = function (e, t) {
      switch (t.type) {
        case j:
          return {};
        case w:
          return function (e) {
            for (var t = 1; t < arguments.length; t++) {
              var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
              "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
                return Object.getOwnPropertyDescriptor(n, e).enumerable
              })))), r.forEach((function (t) {
                g(e, t, n[t])
              }))
            }
            return e
          }({}, e, g({}, t.payload.term, k(y(e[t.payload.term] || []).concat(y((0, c.castArray)(t.payload.results))), t.payload.term)));
        default:
          throw new Error("unknown action")
      }
    }, k = function (e, t) {
      var n = (0, c.uniqBy)(e, "key");
      if (n.length <= 1) return n;
      var r = new x.Z(n, {
        includeScore: !0,
        keys: ["indexed"],
        shouldSort: !1,
        includeMatches: !0,
        minMatchCharLength: 2,
        threshold: .5
      }).search(t);
      return (0, c.orderBy)(r, ["score", "item.item.hotspotCount"], ["asc", "desc"]).map((function (e) {
        return e.item
      }))
    }, N = function () {
      return (0, a.useReducer)(b, {})
    }, S = n(65513), C = n.n(S), L = n(93843);

    function T(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    var P = function () {
        var e = (0, L.ZP)("/makers").data, t = (0, a.useMemo)((function () {
          return e ? e.map((function (e) {
            return function (e) {
              for (var t = 1; t < arguments.length; t++) {
                var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
                "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
                  return Object.getOwnPropertyDescriptor(n, e).enumerable
                })))), r.forEach((function (t) {
                  T(e, t, n[t])
                }))
              }
              return e
            }({}, e, {
              dcBalance: new (C())(e.balanceInfo.dcBalance.integerBalance, S.CurrencyType.dataCredit),
              burnedHNT: new (C())(e.txns.tokenBurnAmountInBones, S.CurrencyType.networkToken),
              assertsRemaining: Math.floor(e.balanceInfo.dcBalance.integerBalance / 5e6)
            })
          })) : []
        }), [e]);
        return {makers: t}
      }, A = function (e) {
        var t = P().makers, n = (0, a.useState)(), r = n[0], s = n[1], i = (0, a.useState)(!0), o = i[0], l = i[1];
        return (0, a.useEffect)((function () {
          if (t) {
            l(!1);
            var n = t.find((function (t) {
              return t.address === e
            }));
            n && s(n)
          }
        }), [e, t]), {maker: r, isLoading: o}
      }, M = n(75805), _ = n.n(M), O = n(72895), H = n(89947), I = n(52081), B = n.n(I),
      E = JSON.parse('[["Afghanistan","AF","AFG"],["\xc5land Islands","AX","ALA"],["Albania","AL","ALB"],["Algeria","DZ","DZA"],["American Samoa","AS","ASM"],["Andorra","AD","AND"],["Angola","AO","AGO"],["Anguilla","AI","AIA"],["Antarctica","AQ","ATA"],["Antigua and Barbuda","AG","ATG"],["Argentina","AR","ARG"],["Armenia","AM","ARM"],["Aruba","AW","ABW"],["Australia","AU","AUS"],["Austria","AT","AUT"],["Azerbaijan","AZ","AZE"],["Bahamas","BS","BHS"],["Bahrain","BH","BHR"],["Bangladesh","BD","BGD"],["Barbados","BB","BRB"],["Belarus","BY","BLR"],["Belgium","BE","BEL"],["Belize","BZ","BLZ"],["Benin","BJ","BEN"],["Bermuda","BM","BMU"],["Bhutan","BT","BTN"],["Bolivia","BO","BOL"],["Bonaire, Sint Eustatius and Saba","BQ","BES"],["Bosnia And Herzegovina","BA","BIH"],["Botswana","BW","BWA"],["Bouvet Island","BV","BVT"],["Brazil","BR","BRA"],["British Indian Ocean Territory","IO","IOT"],["Brunei Darussalam","BN","BRN"],["Bulgaria","BG","BGR"],["Burkina Faso","BF","BFA"],["Burundi","BI","BDI"],["Cabo Verde","CV","CPV"],["Cambodia","KH","KHM"],["Cameroon","CM","CMR"],["Canada","CA","CAN"],["Cayman Islands","KY","CYM"],["Central African Republic","CF","CAF"],["Chad","TD","TCD"],["Chile","CL","CHL"],["China","CN","CHN"],["Christmas Island","CX","CXR"],["Cocos (Keeling) Islands","CC","CCK"],["Colombia","CO","COL"],["Comoros","KM","COM"],["Congo","CG","COG"],["Congo (Democratic Republic Of The)","CD","COD"],["Cook Islands","CK","COK"],["Costa Rica","CR","CRI"],["C\xf4te D\'Ivoire","CI","CIV"],["Croatia","HR","HRV"],["Cuba","CU","CUB"],["Cura\xe7ao","CW","CUW"],["Cyprus","CY","CYP"],["Czech Republic","CZ","CZE"],["Denmark","DK","DNK"],["Djibouti","DJ","DJI"],["Dominica","DM","DMA"],["Dominican Republic","DO","DOM"],["Ecuador","EC","ECU"],["Egypt","EG","EGY"],["El Salvador","SV","SLV"],["Equatorial Guinea","GQ","GNQ"],["Eritrea","ER","ERI"],["Estonia","EE","EST"],["Eswatini","SZ","SWZ"],["Ethiopia","ET","ETH"],["Falkland Islands (Malvinas)","FK","FLK"],["Faroe Islands","FO","FRO"],["Fiji","FJ","FJI"],["Finland","FI","FIN"],["France","FR","FRA"],["French Guiana","GF","GUF"],["French Polynesia","PF","PYF"],["French Southern Territories","TF","ATF"],["Gabon","GA","GAB"],["Gambia","GM","GMB"],["Georgia","GE","GEO"],["Germany","DE","DEU"],["Ghana","GH","GHA"],["Gibraltar","GI","GIB"],["Greece","GR","GRC"],["Greenland","GL","GRL"],["Grenada","GD","GRD"],["Guadeloupe","GP","GLP"],["Guam","GU","GUM"],["Guatemala","GT","GTM"],["Guernsey","GG","GGY"],["Guinea","GN","GIN"],["Guinea Bissau","GW","GNB"],["Guyana","GY","GUY"],["Haiti","HT","HTI"],["Heard Island and McDonald Islands","HM","HMD"],["Holy See","VA","VAT"],["Honduras","HN","HND"],["Hong Kong","HK","HKG"],["Hungary","HU","HUN"],["Iceland","IS","ISL"],["India","IN","IND"],["Indonesia","ID","IDN"],["Iran","IR","IRN"],["Iraq","IQ","IRQ"],["Ireland","IE","IRL"],["Isle of Man","IM","IMN"],["Israel","IL","ISR"],["Italy","IT","ITA"],["Jamaica","JM","JAM"],["Japan","JP","JPN"],["Jersey","JE","JEY"],["Jordan","JO","JOR"],["Kazakhstan","KZ","KAZ"],["Kenya","KE","KEN"],["Kiribati","KI","KIR"],["South Korea","KP","PRK"],["Korea, Republic of","KR","KOR"],["Kuwait","KW","KWT"],["Kyrgyzstan","KG","KGZ"],["Laos","LA","LAO"],["Latvia","LV","LVA"],["Lebanon","LB","LBN"],["Lesotho","LS","LSO"],["Liberia","LR","LBR"],["Libya","LY","LBY"],["Liechtenstein","LI","LIE"],["Lithuania","LT","LTU"],["Luxembourg","LU","LUX"],["Macao","MO","MAC"],["Madagascar","MG","MDG"],["Malawi","MW","MWI"],["Malaysia","MY","MYS"],["Maldives","MV","MDV"],["Mali","ML","MLI"],["Malta","MT","MLT"],["Marshall Islands","MH","MHL"],["Martinique","MQ","MTQ"],["Mauritania","MR","MRT"],["Mauritius","MU","MUS"],["Mayotte","YT","MYT"],["Mexico","MX","MEX"],["Micronesia (Federated States of)","FM","FSM"],["Moldova","MD","MDA"],["Monaco","MC","MCO"],["Mongolia","MN","MNG"],["Montenegro","ME","MNE"],["Montserrat","MS","MSR"],["Morocco","MA","MAR"],["Mozambique","MZ","MOZ"],["Myanmar","MM","MMR"],["Namibia","NA","NAM"],["Nauru","NR","NRU"],["Nepal","NP","NPL"],["Netherlands","NL","NLD"],["New Caledonia","NC","NCL"],["New Zealand","NZ","NZL"],["Nicaragua","NI","NIC"],["Niger","NE","NER"],["Nigeria","NG","NGA"],["Niue","NU","NIU"],["Norfolk Island","NF","NFK"],["Macedonia","MK","MKD"],["Northern Mariana Islands","MP","MNP"],["Norway","NO","NOR"],["Oman","OM","OMN"],["Pakistan","PK","PAK"],["Palau","PW","PLW"],["Palestine, State of","PS","PSE"],["Panama","PA","PAN"],["Papua New Guinea","PG","PNG"],["Paraguay","PY","PRY"],["Peru","PE","PER"],["Philippines","PH","PHL"],["Pitcairn","PN","PCN"],["Poland","PL","POL"],["Portugal","PT","PRT"],["Puerto Rico","PR","PRI"],["Qatar","QA","QAT"],["R\xe9union","RE","REU"],["Romania","RO","ROU"],["Russia","RU","RUS"],["Rwanda","RW","RWA"],["Saint Barth\xe9lemy","BL","BLM"],["Saint Helena, Ascension and Tristan da Cunha","SH","SHN"],["Saint Kitts and Nevis","KN","KNA"],["Saint Lucia","LC","LCA"],["Saint Martin (French part)","MF","MAF"],["Saint Pierre and Miquelon","PM","SPM"],["Saint Vincent and the Grenadines","VC","VCT"],["Samoa","WS","WSM"],["San Marino","SM","SMR"],["Sao Tome and Principe","ST","STP"],["Saudi Arabia","SA","SAU"],["Senegal","SN","SEN"],["Serbia","RS","SRB"],["Seychelles","SC","SYC"],["Sierra Leone","SL","SLE"],["Singapore","SG","SGP"],["Sint Maarten (Dutch part)","SX","SXM"],["Slovakia","SK","SVK"],["Slovenia","SI","SVN"],["Solomon Islands","SB","SLB"],["Somalia","SO","SOM"],["South Africa","ZA","ZAF"],["South Georgia and the South Sandwich Islands","GS","SGS"],["South Sudan","SS","SSD"],["Spain","ES","ESP"],["Sri Lanka","LK","LKA"],["Sudan","SD","SDN"],["Suriname","SR","SUR"],["Svalbard and Jan Mayen","SJ","SJM"],["Sweden","SE","SWE"],["Switzerland","CH","CHE"],["Syria","SY","SYR"],["Taiwan","TW","TWN"],["Tajikistan","TJ","TJK"],["Tanzania","TZ","TZA"],["Thailand","TH","THA"],["Timor-Leste","TL","TLS"],["Togo","TG","TGO"],["Tokelau","TK","TKL"],["Tonga","TO","TON"],["Trinidad and Tobago","TT","TTO"],["Tunisia","TN","TUN"],["Turkey","TR","TUR"],["Turkmenistan","TM","TKM"],["Turks and Caicos Islands","TC","TCA"],["Tuvalu","TV","TUV"],["Uganda","UG","UGA"],["Ukraine","UA","UKR"],["United Arab Emirates","AE","ARE"],["United Kingdom","GB","GBR"],["United States","US","USA"],["United States Minor Outlying Islands","UM","UMI"],["Uruguay","UY","URY"],["Uzbekistan","UZ","UZB"],["Vanuatu","VU","VUT"],["Venezuela","VE","VEN"],["Vietnam","VN","VNM"],["Virgin Islands (British)","VG","VGB"],["Virgin Islands (U.S.)","VI","VIR"],["Wallis and Futuna","WF","WLF"],["Western Sahara","EH","ESH"],["Yemen","YE","YEM"],["Zambia","ZM","ZMB"],["Zimbabwe","ZW","ZWE"]]');

    function F(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function D(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return F(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return F(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var Z = function (e) {
      var t = 1e9;
      return e >= t ? [(0, c.round)(e / t, 3), "B"].join("") : [(0, c.round)(e / 1e6, 3), "M"].join("")
    }, R = function (e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 2;
      return e.toLocaleString(void 0, {style: "percent", maximumFractionDigits: t})
    }, G = function (e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 10;
      return "".concat(e.slice(0, t), "...").concat(e.slice(-t))
    }, V = function (e) {
      for (var t = (e = e.replaceAll(";", "")).split(), n = "", r = 0; r < E.length; r++) {
        var a = D(E[r], 3), s = a[0], i = a[1], o = a[2], l = t[t.length - 1].toLowerCase();
        if (l === s.toLowerCase() || l === i.toLowerCase() || l === o.toLowerCase()) {
          n = i.toLowerCase(), e = (t = t.slice(0, t.length - 1)).join(" ");
          break
        }
      }
      var c = {address: e};
      return "" !== n && (c.country = n), c
    }, W = n(80537), U = n(67014);

    function z(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function K(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function q(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            K(s, r, a, i, o, "next", e)
          }

          function o(e) {
            K(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function $(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return z(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return z(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var J = function (e, t) {
      switch (t) {
        case"hotspot":
        case"dataonly":
        case"account":
        case"validator":
          var n;
          return {
            type: t,
            item: e,
            key: e.address,
            indexed: null === (n = e.name) || void 0 === n ? void 0 : n.replaceAll("-", " ")
          };
        case"block":
        case"transaction":
          return {type: t, item: e, key: e.hash, indexed: e.hash};
        case"city":
          return {type: t, item: e, key: e.cityId, indexed: [e.longCity]};
        case"hex":
          return {type: t, item: e, key: e.index, indexed: e.placeName};
        case"maker":
          return {type: t, item: e, key: e.address, indexed: e.name};
        default:
          return "unknown"
      }
    };

    function Y(e) {
      return e.match(/^[A-Za-z0-9_-]+$/)
    }

    function X(e) {
      if (!e.match(/^\d+$/)) return !1;
      var t = parseInt(e);
      return "NaN" !== t && t > 0
    }

    var Q = function () {
        var e = (0, a.useState)(""), t = e[0], n = e[1], r = $(N(), 2), s = r[0], i = r[1], o = (0, a.useState)(!0),
          l = o[0], c = o[1], u = (0, U.Z)(), d = (0, a.useContext)(W.h).state.searchFocused,
          v = (0, a.useCallback)((function (e) {
            u({type: W.V9, payload: e})
          }), [u]), g = P().makers, y = (0, a.useCallback)(function () {
            var e = q(f().mark((function e(t) {
              var n, r;
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    return e.prev = 0, e.next = 3, m.ZP.hotspots.search(t);
                  case 3:
                    return n = e.sent, e.next = 6, n.take(20);
                  case 6:
                    r = e.sent.map((function (e) {
                      return "dataonly" === e.mode ? J(e, "dataonly") : J(e, "hotspot")
                    })), i({type: w, payload: {results: r, term: t}}), e.next = 12;
                    break;
                  case 10:
                    e.prev = 10, e.t0 = e.catch(0);
                  case 12:
                  case"end":
                    return e.stop()
                }
              }), e, null, [[0, 10]])
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), [i]), b = (0, a.useCallback)(function () {
            var e = q(f().mark((function e(t) {
              var n, r;
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    return e.prev = 0, e.next = 3, m.ZP.validators.search(t);
                  case 3:
                    return n = e.sent, e.next = 6, n.take(20);
                  case 6:
                    r = e.sent.map((function (e) {
                      return J(e, "validator")
                    })), i({type: w, payload: {results: r, term: t}}), e.next = 12;
                    break;
                  case 10:
                    e.prev = 10, e.t0 = e.catch(0);
                  case 12:
                  case"end":
                    return e.stop()
                }
              }), e, null, [[0, 10]])
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), [i]), k = (0, a.useCallback)(function () {
            var e = q(f().mark((function e(t) {
              var n, r, a;
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    return e.prev = 3, e.next = 6, m.ZP.hotspots.get(t);
                  case 6:
                    n = e.sent, e.next = 11;
                    break;
                  case 9:
                    e.prev = 9, e.t0 = e.catch(3);
                  case 11:
                    return e.prev = 11, e.next = 14, m.ZP.accounts.get(t);
                  case 14:
                    r = e.sent, e.next = 19;
                    break;
                  case 17:
                    e.prev = 17, e.t1 = e.catch(11);
                  case 19:
                    return e.prev = 19, e.next = 22, m.ZP.validators.get(t);
                  case 22:
                    a = e.sent, e.next = 27;
                    break;
                  case 25:
                    e.prev = 25, e.t2 = e.catch(19);
                  case 27:
                    n ? i({type: w, payload: {results: J(n, "hotspot"), term: t}}) : a ? i({
                      type: w,
                      payload: {results: J(a, "validator"), term: t}
                    }) : r && i({type: w, payload: {results: J(r, "account"), term: t}});
                  case 28:
                  case"end":
                    return e.stop()
                }
              }), e, null, [[3, 9], [11, 17], [19, 25]])
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), [i]), S = (0, a.useCallback)(function () {
            var e = q(f().mark((function e(t) {
              var n;
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    return e.prev = 0, e.next = 3, m.ZP.blocks.get(t);
                  case 3:
                    (n = e.sent) && i({type: w, payload: {results: J(n, "block"), term: t}}), e.next = 9;
                    break;
                  case 7:
                    e.prev = 7, e.t0 = e.catch(0);
                  case 9:
                  case"end":
                    return e.stop()
                }
              }), e, null, [[0, 7]])
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), [i]), C = (0, a.useCallback)(function () {
            var e = q(f().mark((function e(t) {
              var n;
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    return e.prev = 0, e.next = 3, m.ZP.transactions.get(t);
                  case 3:
                    (n = e.sent) && i({type: w, payload: {results: J(n, "transaction"), term: t}}), e.next = 9;
                    break;
                  case 7:
                    e.prev = 7, e.t0 = e.catch(0);
                  case 9:
                  case"end":
                    return e.stop()
                }
              }), e, null, [[0, 7]])
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), [i]), L = ((0, a.useCallback)(function () {
            var e = q(f().mark((function e(t) {
              var n, r;
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    return e.next = 2, m.ZP.cities.list({query: t});
                  case 2:
                    return e.next = 4, e.sent.take(20);
                  case 4:
                    n = e.sent, r = n.map((function (e) {
                      return J(e, "city")
                    })), i({type: w, payload: {results: r, term: t}});
                  case 7:
                  case"end":
                    return e.stop()
                }
              }), e)
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), [i]), (0, a.useCallback)(function () {
            var e = q(f().mark((function e(t) {
              var n, r, a, s, o;
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    return n = V(t), r = B()({accessToken: "pk.eyJ1IjoicGV0ZXJtYWluIiwiYSI6ImNrbXV5OTFibjAwYzAycXBmMTgyNG5tbzEifQ.SBG9J52tWMtnzei4-j-nIg"}), e.next = 4, r.forwardGeocode({
                      query: n.address,
                      limit: 2,
                      countries: n.countries
                    }).send();
                  case 4:
                    return a = e.sent, s = Promise.all(a.body.features.map(function () {
                      var e = q(f().mark((function e(n) {
                        var r, a, s, i, o, l, c, u, d;
                        return f().wrap((function (e) {
                          for (; ;) switch (e.prev = e.next) {
                            case 0:
                              if (a = n.center, s = {
                                type: "Feature",
                                geometry: {
                                  type: "Polygon",
                                  coordinates: [[[a[0] - 1e-4, a[1] - 1e-4], [a[0] + 1e-4, a[1] - 1e-4], [a[0], a[1] + 1e-4]]]
                                }
                              }, 0 !== (i = _().featureToH3Set(s, 8, {ensureOutput: !0})).length) {
                                e.next = 6;
                                break
                              }
                              return e.abrupt("return");
                            case 6:
                              return o = i[0], e.next = 9, m.ZP.hotspots.hex(o);
                            case 9:
                              return e.next = 11, e.sent.take(100);
                            case 11:
                              return l = e.sent, c = null === (r = n.context) || void 0 === r ? void 0 : r.find((function (e) {
                                return e.id.includes("country")
                              })), u = c ? c.short_code : null, d = {
                                index: o,
                                feature: (0, O.h3SetToFeatureCollection)(o),
                                center: (0, H.h3ToGeo)(o),
                                hotspots: l,
                                hotspotCount: l.length,
                                placeName: n.place_name,
                                countryCode: u,
                                searchText: t
                              }, e.abrupt("return", J(d, "hex"));
                            case 16:
                            case"end":
                              return e.stop()
                          }
                        }), e)
                      })));
                      return function (t) {
                        return e.apply(this, arguments)
                      }
                    }())), e.next = 8, s;
                  case 8:
                    o = e.sent, i({type: w, payload: {results: o, term: t}});
                  case 10:
                  case"end":
                    return e.stop()
                }
              }), e)
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), [i])), T = (0, a.useCallback)(function () {
            var e = q(f().mark((function e(t) {
              var n, r, a;
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    n = new x.Z(g, {
                      includeScore: !0,
                      keys: ["name"],
                      minMatchCharLength: 3,
                      threshold: .3
                    }), r = n.search(t), a = r.map((function (e) {
                      return J(e.item, "maker")
                    })), i({type: w, payload: {results: a, term: t}});
                  case 4:
                  case"end":
                    return e.stop()
                }
              }), e)
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), [i, g]), A = (0, p.Z)(function () {
            var e = q(f().mark((function e(t) {
              return f().wrap((function (e) {
                for (; ;) switch (e.prev = e.next) {
                  case 0:
                    if (c(!0), i({type: j}), !X(t)) {
                      e.next = 7;
                      break
                    }
                    return e.next = 5, S(parseInt(t));
                  case 5:
                    e.next = 41;
                    break;
                  case 7:
                    if (!h.Address.isValid(t)) {
                      e.next = 12;
                      break
                    }
                    return e.next = 10, k(t);
                  case 10:
                    e.next = 41;
                    break;
                  case 12:
                    if (!(t.length > 20 && Y(t))) {
                      e.next = 25;
                      break
                    }
                    return e.t0 = Promise, e.next = 16, S(t);
                  case 16:
                    return e.t1 = e.sent, e.next = 19, C(t);
                  case 19:
                    return e.t2 = e.sent, e.t3 = [e.t1, e.t2], e.next = 23, e.t0.all.call(e.t0, e.t3);
                  case 23:
                    e.next = 41;
                    break;
                  case 25:
                    return e.t4 = Promise, e.next = 28, y(t.replace(/-/g, " "));
                  case 28:
                    return e.t5 = e.sent, e.next = 31, b(t.replace(/-/g, " "));
                  case 31:
                    return e.t6 = e.sent, e.next = 34, L(t);
                  case 34:
                    return e.t7 = e.sent, e.next = 37, T(t);
                  case 37:
                    return e.t8 = e.sent, e.t9 = [e.t5, e.t6, e.t7, e.t8], e.next = 41, e.t4.all.call(e.t4, e.t9);
                  case 41:
                    c(!1);
                  case 42:
                  case"end":
                    return e.stop()
                }
              }), e)
            })));
            return function (t) {
              return e.apply(this, arguments)
            }
          }(), 500, {trailing: !0});
        return (0, a.useEffect)((function () {
          if ("" !== t) {
            v(!0), c(!0);
            var e = t.trim();
            A(e)
          } else i({type: j})
        }), [i, A, v, t]), {
          term: t,
          setTerm: n,
          resultsLoading: l,
          searchFocused: d,
          setSearchFocused: v,
          results: s[t] || []
        }
      }, ee = n(14184), te = function (e, t) {
        var n = (0, a.useCallback)((function (n) {
          if (!t) {
            if ("INPUT" === document.activeElement.tagName) return;
            if ("TEXTAREA" === document.activeElement.tagName) return
          }
          e[n.key] && (n.preventDefault(), e[n.key]())
        }), [e, t]);
        (0, a.useEffect)((function () {
          if (t) {
            var e = t.current;
            return e.addEventListener("keydown", n), function () {
              e.removeEventListener("keydown", n)
            }
          }
          return document.addEventListener("keydown", n), function () {
            document.removeEventListener("keydown", n)
          }
        }), [n, t])
      }, ne = n(32738), re = n.n(ne), ae = n(57780), se = n(12828), ie = n.n(se), oe = n(99318), le = n(94184),
      ce = n.n(le), ue = function (e) {
        var t = e.className, n = e.countryCode;
        return n ? (0, r.jsx)("span", {
          className: ce()("w-4 flex flex-row items-center justify-start", t),
          children: (0, r.jsx)(oe.Z, {countryCode: n, svg: !0})
        }) : null
      }, de = function (e) {
        var t = e.geocode, n = e.showLocationName, a = void 0 === n || n, s = e.shortenedLocationName,
          i = e.condensedView, o = void 0 !== i && i, l = ie()(t),
          c = null === l || void 0 === l ? void 0 : l.shortCountry, u = (0, ae.T7)(l, s);
        return o ? (0, r.jsxs)("span", {
          className: "flex flex-row items-center justify-start",
          children: [(0, r.jsx)(ue, {
            className: "mr-1",
            countryCode: c
          }), a && (null === l || void 0 === l ? void 0 : l.shortCity)]
        }) : (0, r.jsxs)("span", {
          className: "flex flex-row items-center justify-start",
          children: [(0, r.jsx)(ue, {className: "mr-1", countryCode: c}), a && u]
        })
      }, fe = n(51756), me = function (e) {
        var t = e.className, n = e.defaultSize, a = void 0 === n || n, s = e.defaultRounding, i = void 0 === s || s,
          o = e.defaultBackground, l = void 0 === o || o;
        return (0, r.jsx)("div", {className: ce()(t, "animate-pulse", {rounded: i, "h-4": a, "bg-gray-400": l})})
      }, he = function (e) {
        var t = e.address, n = e.truncate, a = void 0 !== n && n, s = e.tooltip, i = e.mono, o = e.showSecondHalf,
          l = void 0 === o || o, u = e.classes, d = (0, c.isInteger)(a) ? a : 10;
        return t ? (0, r.jsx)(fe.Z, {
          title: s,
          children: (0, r.jsx)("span", {
            className: ce()("break-all cursor-pointer", u, {"font-mono": i}),
            children: a ? (0, r.jsxs)("span", {
              children: [t.slice(0, d), (0, r.jsx)("span", {
                className: "text-gray-525 px-0.5 tracking-wide",
                children: "..."
              }), l && (0, r.jsx)("span", {children: t.slice(-d)})]
            }) : t
          })
        }) : (0, r.jsx)(me, {})
      }, pe = function (e) {
        var t = e.className;
        return (0, r.jsx)("svg", {
          width: "21",
          height: "20",
          viewBox: "0 0 21 20",
          fill: "none",
          xmlns: "http://www.w3.org/2000/svg",
          className: t,
          children: (0, r.jsx)("path", {
            "fill-rule": "evenodd",
            "clip-rule": "evenodd",
            d: "M4.91309 0C2.70395 0 0.913086 1.79086 0.913086 4V15.9553C0.913086 18.1644 2.70394 19.9553 4.91308 19.9553H16.8684C19.0775 19.9553 20.8684 18.1644 20.8684 15.9553V4C20.8684 1.79086 19.0775 0 16.8684 0H4.91309ZM10.8907 17.5822C15.0906 17.5822 18.4953 14.1775 18.4953 9.97763C18.4953 5.77773 15.0906 2.37305 10.8907 2.37305C6.69082 2.37305 3.28613 5.77773 3.28613 9.97763C3.28613 14.1775 6.69082 17.5822 10.8907 17.5822Z",
            fill: "currentColor"
          })
        })
      }, xe = function (e) {
        var t = e.className;
        return (0, r.jsx)("svg", {
          width: "26",
          height: "31",
          viewBox: "0 0 26 31",
          fill: "none",
          xmlns: "http://www.w3.org/2000/svg",
          className: t,
          children: (0, r.jsx)("path", {
            "fill-rule": "evenodd",
            "clip-rule": "evenodd",
            d: "M21.561 4.59665C26.4024 9.58151 26.4024 17.6636 21.561 22.6484L14.8179 29.5914C13.7007 30.7418 11.8893 30.7418 10.7721 29.5914L4.02896 22.6484C-0.812387 17.6636 -0.812387 9.58151 4.02896 4.59665C8.8703 -0.388214 16.7197 -0.388214 21.561 4.59665ZM12.7955 19.9476C16.3603 19.9476 19.2501 16.9728 19.2501 13.3032C19.2501 9.63353 16.3603 6.65869 12.7955 6.65869C9.23066 6.65869 6.34082 9.63353 6.34082 13.3032C6.34082 16.9728 9.23066 19.9476 12.7955 19.9476Z",
            fill: "currentColor"
          })
        })
      }, ve = function (e) {
        var t = e.title, n = e.color, a = void 0 === n ? "gray" : n, s = e.tooltip;
        return (0, r.jsx)(fe.Z, {
          title: s,
          children: (0, r.jsx)("span", {
            className: ce()("px-2 py-1 text-white text-xs font-medium whitespace-nowrap rounded-full", {
              "bg-green-500": "green" === a,
              "bg-gray-700": "gray" === a,
              "bg-yellow-500": "yellow" === a,
              "bg-purple-500": "purple" === a,
              "bg-reward-witness": "witness" === a,
              "bg-reward-challenger": "challenger" === a,
              "bg-reward-challengee": "challengee" === a,
              "bg-reward-data": "data" === a,
              "bg-reward-consensus": "consensus" === a
            }), children: t
          })
        })
      }, ge = {validator: "purple", hotspot: "green", hex: "green"}, ye = {dataonly: "Data Only"}, je = function (e) {
        var t = e.title, n = e.subtitle, a = e.type, s = e.onSelect, i = e.selected;
        return (0, r.jsxs)("div", {
          className: ce()("border-solid py-2 px-4 flex hover:bg-gray-350 cursor-pointer", {"bg-gray-350": i}),
          onClick: s,
          children: [(0, r.jsxs)("div", {
            className: "w-full",
            children: [(0, r.jsx)("div", {
              className: "font-medium text-base text-navy-1000",
              children: t
            }), (0, r.jsx)("div", {className: "text-gray-700 text-sm", children: n})]
          }), (0, r.jsx)("div", {
            className: "flex items-center px-2",
            children: a && (0, r.jsx)(ve, {title: ye[a] ? ye[a] : (0, c.capitalize)(a), color: ge[a] || "gray"})
          }), (0, r.jsx)("div", {
            className: "flex",
            children: (0, r.jsx)("img", {alt: "", src: "/images/details-arrow.svg"})
          })]
        })
      };

    function we(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function be(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return we(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return we(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var ke = function (e) {
      return [e.slice(0, 10), e.slice(-10)].join("...")
    }, Ne = function (e) {
      var t = e.result, n = e.onSelect, s = e.selected, i = void 0 !== s && s, o = (0, a.useCallback)((function () {
        n(t)
      }), [n, t]);
      if ("hotspot" === t.type || "dataonly" === t.type) return (0, r.jsx)(je, {
        title: (0, ae.$x)(t.item.name),
        subtitle: (0, r.jsx)(de, {geocode: t.item.geocode}),
        type: t.type,
        selected: i,
        onSelect: o
      });
      if ("validator" === t.type) return (0, r.jsx)(je, {
        title: (0, ae.$x)(t.item.name),
        subtitle: (0, r.jsxs)("div", {
          className: "flex items-center space-x-1",
          children: [(0, r.jsx)("img", {
            src: "/images/penalty.svg",
            className: "w-3"
          }), " ", (0, r.jsx)("span", {children: (0, c.round)(t.item.penalty, 2)})]
        }),
        type: t.type,
        selected: i,
        onSelect: o
      });
      if ("account" === t.type) return (0, r.jsx)(je, {
        title: (0, r.jsx)(he, {address: t.item.address, truncate: !0}),
        subtitle: [t.item.balance.toString(2), t.item.secBalance.toString(2), t.item.dcBalance.toString()].join(" "),
        type: t.type,
        selected: i,
        onSelect: o
      });
      if ("block" === t.type) return (0, r.jsx)(je, {
        title: "#".concat(t.item.height.toLocaleString()),
        subtitle: (0, r.jsxs)("span", {
          className: "flex space-x-2",
          children: [(0, r.jsx)(re(), {date: t.item.time}), (0, r.jsxs)("span", {children: [t.item.transactionCount.toLocaleString(), " tx"]})]
        }),
        type: t.type,
        selected: i,
        onSelect: o
      });
      if ("transaction" === t.type) return (0, r.jsx)(je, {
        title: ke(t.item.hash),
        subtitle: (0, r.jsx)(re(), {date: t.item.time}),
        type: t.type,
        selected: i,
        onSelect: o
      });
      if ("city" === t.type) return (0, r.jsx)(je, {
        title: [t.item.longCity, t.item.shortState, t.item.shortCountry].join(", "),
        subtitle: "".concat(t.item.hotspotCount.toLocaleString(), " Hotspots"),
        type: t.type,
        selected: i,
        onSelect: o
      });
      if ("hex" === t.type) {
        var l = be(t.item.placeName.split(",", 1), 1)[0], u = [t.item.placeName.substr(l.length + 1)];
        return (0, r.jsx)(je, {
          title: (0, r.jsxs)("div", {
            className: "flex flex-col items-start justify-start",
            children: [(0, r.jsx)("span", {
              className: "",
              children: l
            }), (0, r.jsxs)("div", {
              className: "flex items-start justify-start",
              children: [(0, r.jsx)(ue, {
                countryCode: t.item.countryCode,
                className: "mr-1.5 w-3 h-auto"
              }), (0, r.jsx)("span", {className: "text-xs text-gray-600", children: u})]
            })]
          }),
          subtitle: "".concat(t.item.hotspotCount.toLocaleString(), " Hotspots"),
          type: t.type,
          selected: i,
          onSelect: o
        })
      }
      return "maker" === t.type ? (0, r.jsx)(je, {
        title: t.item.name,
        subtitle: (0, r.jsxs)("div", {
          className: "flex space-x-2",
          children: [(0, r.jsxs)("div", {
            className: "flex items-center space-x-1",
            children: [(0, r.jsx)(pe, {className: "text-green-500 w-3 h-auto"}), (0, r.jsx)("span", {children: t.item.txns.addGatewayTxns.toLocaleString()})]
          }), (0, r.jsxs)("div", {
            className: "flex items-center space-x-1",
            children: [(0, r.jsx)(xe, {className: "text-pink-500 w-3 h-auto"}), (0, r.jsx)("span", {children: t.item.txns.assertLocationTxns.toLocaleString()})]
          })]
        }),
        type: t.type,
        selected: i,
        onSelect: o
      }) : null
    }, Se = n(38864), Ce = n(67038), Le = n(81034), Te = n(98868), Pe = function (e) {
      var t = e.resultsLoading, n = e.results, a = e.handleSelectResult, s = e.selectedResultIndex;
      return t ? (0, r.jsx)(je, {
        title: "Loading results...",
        subtitle: "Talking to the API..."
      }) : 0 === n.length ? (0, r.jsx)(je, {
        title: "No results found",
        subtitle: "Try another query"
      }) : n.map((function (e, t) {
        return (0, r.jsx)(Ne, {result: e, onSelect: a, selected: s === t}, e.key)
      }))
    }, Ae = function () {
      var e = (0, a.useRef)(), t = (0, a.useRef)(), n = Q(), s = n.term, o = n.setTerm, d = n.results,
        f = n.resultsLoading, m = n.searchFocused, h = n.setSearchFocused, p = (0, a.useState)(0), x = p[0], v = p[1],
        g = (0, ee.Z)().selectHotspot, y = (0, Se.Z)().selectTxn, j = (0, Ce.Z)().selectCity, w = (0, Le.Z)().selectHex,
        b = (0, a.useContext)(Te.Z).showBanner, k = (0, i.k6)(), N = (0, a.useCallback)((function (e) {
          o(e.target.value), v(0)
        }), [o]), S = (0, a.useCallback)((function (e) {
          o(""), "hotspot" !== e.type && "dataonly" !== e.type || (g(e.item.address), k.push("/hotspots/".concat(e.item.address))), "validator" === e.type && k.push("/validators/".concat(e.item.address)), "account" !== e.type && "maker" !== e.type || k.push("/accounts/".concat(e.item.address)), "block" === e.type && k.push("/blocks/".concat(e.item.height)), "transaction" === e.type && (y(e.item.hash), k.push("/txns/".concat(e.item.hash))), "city" === e.type && j(e.item), "hex" === e.type && w(e.item.index)
        }), [k, j, w, g, y, o]), C = (0, a.useCallback)((function () {
          o("")
        }), [o]);
      return te({
        "/": function () {
          e.current.focus()
        }
      }), te({
        ArrowDown: function () {
          0 !== d.length && v((0, c.clamp)(x + 1, 0, d.length - 1))
        }, ArrowUp: function () {
          0 !== d.length && v((0, c.clamp)(x - 1, 0, d.length - 1))
        }, Enter: function () {
          var t;
          f || (null === e || void 0 === e || null === (t = e.current) || void 0 === t || t.blur(), h(!1), S(d[x]))
        }
      }, e), (0, a.useEffect)((function () {
        var e, n;
        (null === t || void 0 === t || null === (e = t.current) || void 0 === e || null === (n = e.children) || void 0 === n ? void 0 : n[x]) && t.current.children[x].scrollIntoView({
          behavior: "smooth",
          block: "nearest",
          inline: "nearest"
        })
      }), [x]), (0, r.jsxs)("div", {
        className: "",
        children: [(0, r.jsxs)("div", {
          className: ce()("relative bg-white transition-all rounded-full duration-200 h-8 flex overflow-hidden", {
            "w-full md:w-96": m,
            "w-60": !m
          }),
          children: [(0, r.jsx)("div", {
            className: "absolute flex left-2 h-full pointer-events-none",
            children: (0, r.jsx)(l.default, {src: "/images/search.svg", width: 16, height: 16})
          }), (0, r.jsx)("input", {
            ref: e,
            type: "search",
            onFocus: function () {
              return h(!0)
            },
            onBlur: function () {
              return h(!1)
            },
            value: s,
            onChange: N,
            className: ce()("w-full border-none outline-none text-base font-sans placeholder-gray-525 z-40 pl-4 pr-7", {"placeholder-gray-700": m}),
            placeholder: m ? "Search a hotspot, city, address, maker, etc." : "Search..."
          }), s.length > 0 && (0, r.jsx)("div", {
            className: "absolute flex items-center right-2 h-full text-gray-550 cursor-pointer z-40",
            onClick: C,
            children: (0, r.jsx)(u.Z, {})
          })]
        }), s.length > 0 && (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)("div", {
            ref: t,
            className: ce()("absolute bg-white max-h-96 md:max-h-72 md:w-96 left-2 md:left-auto right-2 lg:right-4 rounded-lg divide-y divide-gray-400 overflow-y-scroll no-scrollbar shadow-md z-40", {
              "top-14": !b,
              "top-20": b
            }),
            children: (0, r.jsx)(Pe, {resultsLoading: f, results: d, handleSelectResult: S, selectedResultIndex: x})
          }), (0, r.jsx)("div", {
            className: ce()("md:hidden absolute transition-all duration-500 ease-in-out top-0 z-30 left-0 h-screen w-screen mobilenav-blur", {
              "opacity-0": (0 === d.length || 0 === s.length) && !m && !f,
              "opacity-100": m || d.length > 0 || s.length > 0 || f
            })
          })]
        })]
      })
    }, Me = function (e) {
      var t = e.hasNewNotifications, n = e.className;
      return t ? (0, r.jsx)("svg", {
        xmlns: "http://www.w3.org/2000/svg",
        className: ce()({"h-5 w-5": !n}, n),
        viewBox: "0 0 20 20",
        fill: "currentColor",
        children: (0, r.jsx)("path", {d: "M10 2a6 6 0 00-6 6v3.586l-.707.707A1 1 0 004 14h12a1 1 0 00.707-1.707L16 11.586V8a6 6 0 00-6-6zM10 18a3 3 0 01-3-3h6a3 3 0 01-3 3z"})
      }) : (0, r.jsx)("svg", {
        xmlns: "http://www.w3.org/2000/svg",
        className: ce()({"h-6 w-6": !n}, n),
        fill: "none",
        viewBox: "0 0 24 24",
        stroke: "currentColor",
        children: (0, r.jsx)("path", {
          strokeLinecap: "round",
          strokeLinejoin: "round",
          strokeWidth: 2,
          d: "M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9"
        })
      })
    }, _e = n(23070), Oe = n(52379), He = function (e) {
      var t = e.className, n = (0, a.useContext)(Oe.Z), s = n.showChangelog, i = n.changelogState,
        o = n.initializeChangelogItem, l = n.setAllChangelogItemsAsSeen, c = (0, a.useState)(!1), u = c[0], d = c[1];
      return (0, a.useEffect)((function () {
        var e = Object.keys(_e.i), t = !1;
        (null === e || void 0 === e ? void 0 : e.length) > 0 && e.forEach((function (e) {
          var n, r;
          (null === (n = _e.i[e]) || void 0 === n ? void 0 : n.active) && !(null === i || void 0 === i ? void 0 : i.hasOwnProperty(e)) && o(e), (null === (r = _e.i[e]) || void 0 === r ? void 0 : r.active) && (null === i || void 0 === i ? void 0 : i.hasOwnProperty(e)) && !1 === i[e] && (t = !0)
        })), d(t)
      }), [i, o]), (0, r.jsxs)("div", {
        className: ce()(t, "duration-200 transition-all text-gray-400 hover:text-white cursor-pointer relative pt-0.5"),
        onClick: s,
        children: [(0, r.jsx)(Me, {hasNewNotifications: u}), u && (0, r.jsx)("div", {
          className: "absolute z-50 cursor-pointer -top-1 -right-1",
          onClick: l,
          children: (0, r.jsxs)("div", {
            className: "w-3 h-3",
            children: [(0, r.jsx)("div", {className: "animate-ping absolute top-0.5 right-0 inline-flex h-full w-full rounded-full bg-red-400 opacity-75"}), (0, r.jsx)("div", {className: ce()("w-3 h-3", "relative inline-flex rounded-full bg-red-400")})]
          })
        })]
      })
    }, Ie = n(47643), Be = function (e) {
      var t = e.className, n = e.children;
      return (0, r.jsx)("div", {className: t, children: (0, r.jsx)(Ie.W, {projectId: "8ae45d67390358", children: n})})
    }, Ee = function (e) {
      var t = e.className;
      return (0, r.jsx)("svg", {
        xmlns: "http://www.w3.org/2000/svg",
        className: t,
        fill: "none",
        viewBox: "0 0 24 24",
        stroke: "currentColor",
        children: (0, r.jsx)("path", {
          strokeLinecap: "round",
          strokeLinejoin: "round",
          strokeWidth: 2,
          d: "M11 5.882V19.24a1.76 1.76 0 01-3.417.592l-2.147-6.15M18 13a3 3 0 100-6M5.436 13.683A4.001 4.001 0 017 6h1.832c4.1 0 7.625-1.234 9.168-3v14c-1.543-1.766-5.067-3-9.168-3H7a3.988 3.988 0 01-1.564-.317z"
        })
      })
    }, Fe = function (e) {
      var t = e.href, n = e.title, a = e.className, s = e.onClick;
      return e.fallback ? (0, r.jsx)("a", {
        href: t,
        onClick: s,
        className: ce()(a, {"text-white font-sans flex items-center justify-center text-sm hover:text-gray-500 focus:text-gray-600": !a}),
        children: n
      }) : (0, r.jsx)(o.Link, {
        to: t,
        onClick: s,
        className: ce()(a, {"text-white font-sans flex items-center justify-center text-sm hover:text-gray-500 focus:text-gray-600": !a}),
        children: n
      })
    }, De = function (e) {
      var t = e.className, n = e.onNavLinkClick, a = e.navLinkClasses, s = e.fallbackLinks, i = void 0 !== s && s,
        o = Q().searchFocused;
      return (0, r.jsxs)("div", {
        className: ce()(t, "duration-200 transition-all", {"opacity-0": o}),
        children: [(0, r.jsx)(Fe, {
          href: "/hotspots",
          title: "Hotspots",
          className: a,
          onClick: n,
          fallback: i
        }), (0, r.jsx)(Fe, {
          href: "/blocks",
          title: "Blocks",
          className: a,
          onClick: n,
          fallback: i
        }), (0, r.jsx)(Fe, {
          href: "/validators",
          title: "Validators",
          className: a,
          onClick: n,
          fallback: i
        }), (0, r.jsx)(Fe, {
          href: "/market",
          title: "Market",
          className: a,
          onClick: n,
          fallback: i
        }), (0, r.jsx)(Fe, {
          href: "/tools",
          title: "Tools",
          className: a,
          onClick: n,
          fallback: i
        }), (0, r.jsx)(Be, {
          className: "flex",
          children: (0, r.jsx)("div", {
            className: "bg-navy-400 hover:bg-navy-300 px-4 md:px-3 py-1.5 md:py-1 cursor-pointer rounded-lg mt-5 md:mt-0",
            children: (0, r.jsx)("span", {
              className: "text-sm text-white flex items-center",
              children: (0, r.jsx)(Ee, {className: "w-5 h-5 md:h-4 md:w-4 text-white"})
            })
          })
        }), (0, r.jsx)(He, {className: "hidden xl:block xl:-mr-4"})]
      })
    }, Ze = n(54483), Re = n.n(Ze), Ge = function (e) {
      var t = e.className, n = e.onClick;
      return (0, r.jsx)("button", {
        className: ce()("cursor-pointer w-10 h-10 flex items-center justify-center outline-none border-solid border border-transparent focus:border-navy-400", t),
        onClick: n,
        children: (0, r.jsx)("img", {alt: "Close menu icon", src: "/images/close-menu.svg"})
      })
    }, Ve = function (e) {
      var t = e.menuOpen, n = e.toggleMenu;
      return (0, r.jsx)(Re(), {
        active: t,
        children: (0, r.jsx)("div", {
          className: ce()("xl:hidden transform-gpu absolute transition-all duration-100 ease-in-out top-0 z-50 left-0 h-screen w-screen mobilenav-blur", {
            "translate-x-full": !t,
            "translate-x-0": t
          }),
          children: (0, r.jsxs)("div", {
            className: "relative flex flex-col items-center justify-center h-screen w-full p-5 pb-10",
            children: [(0, r.jsx)(Ge, {className: "absolute top-4 right-4", onClick: n}), (0, r.jsx)(o.Link, {
              to: "/",
              className: "pb-10",
              onClick: n,
              children: (0, r.jsx)("img", {
                alt: "Helium Logo",
                src: "/images/logo-sm.svg",
                className: "border-solid border border-transparent focus:border-navy-400"
              })
            }), (0, r.jsx)(De, {
              className: "flex flex-col items-center justify-center space-y-4",
              navLinkClasses: "text-2xl text-white font-sans font-regular border-solid border border-transparent focus:border-navy-400 hover:text-gray-600",
              onNavLinkClick: n
            })]
          })
        })
      })
    }, We = function () {
      var e = arguments.length > 0 && void 0 !== arguments[0] && arguments[0], t = (0, a.useState)(e), n = t[0],
        r = t[1], s = (0, a.useCallback)((function () {
          return r((function (e) {
            return !e
          }))
        }), []);
      return [n, s, r]
    }, Ue = n(59974), ze = function () {
      var e = (0, a.useContext)(Te.Z).hideBanner, t = (0, Ue.Z)().setMapLayer, n = (0, a.useCallback)((function (n) {
        return function () {
          t(n), e()
        }
      }), [e, t]);
      return (0, r.jsx)("div", {
        className: "fixed top-0 mx-auto w-full z-50", children: (0, r.jsxs)("div", {
          className: "relative w-full", children: [(0, r.jsx)("a", {
            className: "bg-navy-400 w-full hover:shadow-lg hover:bg-navy-500 flex items-center pr-8 justify-center transition-all px-0.5 md:px-5 duration-250 text-white text-xs md:text-sm py-0.5 md:py-1 font-sans font-normal md:h-8 h-8 leading-tight tracking-tighter",
            onClick: n("earnings"),
            rel: "noopener noreferrer",
            children: (0, r.jsx)("span", {
              className: "m-0 mr-1 inline-flex w-full items-center justify-center", children: (0, r.jsxs)("span", {
                children: ["Check out the new Earnings Map layer.", " ", (0, r.jsx)("span", {
                  className: "hidden md:inline-flex",
                  children: "Click"
                }), (0, r.jsx)("span", {
                  className: "inline-flex md:hidden",
                  children: "Tap"
                }), " the", (0, r.jsxs)("svg", {
                  width: "20",
                  height: "18",
                  className: "w-3 h-3 md:w-5 md:h-5 inline-flex mx-1 md:mx-1.5",
                  viewBox: "0 0 27 24",
                  fill: "none",
                  xmlns: "http://www.w3.org/2000/svg",
                  children: [(0, r.jsx)("path", {
                    opacity: "0.6",
                    d: "M9.85264 9.68533C11.8494 8.53263 15.0867 8.53262 17.0834 9.68533L24.6781 14.0697C26.6748 15.2224 26.6748 17.0913 24.6781 18.244L17.0834 22.6284C15.0867 23.7811 11.8494 23.7811 9.85265 22.6284L2.25797 18.244C0.261262 17.0913 0.261256 15.2224 2.25797 14.0697L9.85264 9.68533Z",
                    fill: "white",
                    "fill-opacity": "0.61"
                  }), (0, r.jsx)("path", {
                    opacity: "0.8",
                    d: "M9.85264 1.37185C11.8494 0.21915 15.0867 0.219147 17.0834 1.37185L24.6781 5.75625C26.6748 6.90895 26.6748 8.77786 24.6781 9.93056L17.0834 14.315C15.0867 15.4677 11.8494 15.4677 9.85265 14.315L2.25797 9.93056C0.261262 8.77786 0.261256 6.90896 2.25797 5.75626L9.85264 1.37185Z",
                    fill: "white"
                  })]
                }), (0, r.jsx)("span", {
                  className: "inline-flex",
                  children: "icon in the bottom right corner and select Earnings."
                })]
              })
            })
          }), (0, r.jsx)("button", {
            className: "border border-solid absolute right-0 top-0 border-transparent hover:bg-navy-600 w-8 md:w-10 h-full z-40 cursor-pointer bg-navy-500 focus:outline-none focus:border-navy-400 flex items-center justify-center",
            onClick: e,
            children: (0, r.jsx)("svg", {
              xmlns: "http://www.w3.org/2000/svg",
              className: "h-3 w-3 text-white",
              fill: "none",
              viewBox: "0 0 24 24",
              stroke: "currentColor",
              children: (0, r.jsx)("path", {
                strokeLinecap: "round",
                strokeLinejoin: "round",
                strokeWidth: 2,
                d: "M6 18L18 6M6 6l12 12"
              })
            })
          })]
        })
      })
    }, Ke = function () {
      return "mainnet" === m.IB ? null : (0, r.jsx)("a", {
        target: "_blank",
        rel: "noreferrer",
        href: "testnet" === m.IB ? "https://explorer.helium.com" : "https://testnet-explorer.helium.com",
        className: ce()("text-white text-sm cursor-pointer bg-opacity-80 px-3 py-2 rounded hidden md:block absolute left-96", {
          "bg-yellow-800": "testnet" === m.IB,
          "bg-navy-500": "mainnet" === m.IB
        }),
        children: (0, c.capitalize)(m.IB)
      })
    };

    function qe(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function $e(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return qe(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return qe(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var Je = function (e) {
        var t = e.className, n = $e(We(), 2), a = n[0], s = n[1];
        return (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)("div", {
            className: ce()(t, "cursor-pointer xl:hidden block transition-all duration-200", {
              "opacity-100": !a,
              "opacity-0": a
            }), onClick: s, children: (0, r.jsx)("img", {alt: "Menu icon", src: "/images/menu.svg"})
          }), (0, r.jsx)(Ve, {menuOpen: a, toggleMenu: s})]
        })
      }, Ye = function (e) {
        var t = e.fallbackLinks, n = void 0 !== t && t, s = (0, a.useContext)(Te.Z).showBanner, i = Q().searchFocused;
        return (0, r.jsxs)(r.Fragment, {
          children: [s && (0, r.jsx)(ze, {}), (0, r.jsxs)("header", {
            className: ce()("fixed w-full z-30 flex items-center justify-between", {
              "pt-8 md:pt-10": s,
              "p-4": !i,
              "px-2 py-4 md:px-4 md:py-4": i
            }),
            children: [n ? (0, r.jsx)("a", {
              href: "/",
              className: ce()("transition-all duration-200", {"hidden md:flex": i}),
              children: (0, r.jsx)("img", {alt: "Helium Logo", src: "/images/logo-sm.svg"})
            }) : (0, r.jsx)(o.Link, {
              to: "/",
              className: ce()("transition-all duration-200", {"hidden md:flex": i}),
              children: (0, r.jsx)("img", {alt: "Helium Logo", src: "/images/logo-sm.svg"})
            }), (0, r.jsx)(Ke, {}), (0, r.jsxs)("div", {
              className: ce()("grid grid-flow-col gap-8 items-center transition-all duration-200", {"w-full md:w-auto": i}),
              children: [(0, r.jsx)(De, {
                className: "hidden xl:grid grid-flow-col gap-4 w-full",
                fallbackLinks: n
              }), (0, r.jsxs)("div", {
                className: "grid grid-flow-col gap-2 items-center",
                children: [(0, r.jsx)(Ae, {}), (0, r.jsx)(He, {className: "block xl:hidden px-0"}), (0, r.jsx)(Je, {className: ce()("", {hidden: i})})]
              })]
            })]
          })]
        })
      }, Xe = n(65988), Qe = n.n(Xe), et = n(9008), tt = function (e) {
        var t = e.children, n = e.backgroundColor, a = void 0 === n ? "#212E3A" : n;
        return (0, r.jsxs)("div", {
          className: Qe().dynamic([["a512f1a04d3449fb", [a]]]),
          children: [(0, r.jsx)(et.default, {
            children: (0, r.jsx)("link", {
              rel: "icon",
              type: "image/png",
              href: "static/img/favicon.png",
              className: Qe().dynamic([["a512f1a04d3449fb", [a]]])
            })
          }), (0, r.jsx)(Qe(), {
            id: "a512f1a04d3449fb",
            dynamic: [a],
            children: "html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video{margin:0;\npadding:0;\nborder:0;\nfont-size:100%;\nfont:inherit;\nvertical-align:baseline}\narticle, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section{display:block}\nol, ul{list-style:none}\nblockquote, q{quotes:none}\nblockquote:before, blockquote:after, q:before, q:after{content:'';\ncontent:none}\ntable{border-collapse:collapse;\nborder-spacing:0}\nbody{line-height:1;\nmargin:0;\nfont-family:'Inter', Helvetica, Arial, sans-serif;\nbackground:".concat(a, "}\n.mono{font-family:'input-mono', monaco, monospace!important}")
          }), t]
        })
      }, nt = function (e) {
        var t = e.className;
        return (0, r.jsx)("svg", {
          width: "21",
          height: "23",
          viewBox: "0 0 21 23",
          fill: "none",
          xmlns: "http://www.w3.org/2000/svg",
          className: t,
          children: (0, r.jsx)("path", {
            d: "M7.94059 1.38432C9.35135 0.569812 11.0895 0.56981 12.5003 1.38432L17.87 4.48454C19.2808 5.29904 20.1498 6.80431 20.1498 8.43333V14.6338C20.1498 16.2628 19.2808 17.7681 17.87 18.5826L12.5003 21.6828C11.0895 22.4973 9.35136 22.4973 7.94059 21.6828L2.57085 18.5826C1.16009 17.7681 0.291016 16.2628 0.291016 14.6338V8.43333C0.291016 6.80432 1.16008 5.29904 2.57085 4.48454L7.94059 1.38432Z",
            fill: "currentColor"
          })
        })
      }, rt = function (e) {
        var t = e.title, n = e.onClick, a = e.icon, s = e.active, i = void 0 !== s && s, o = e.style;
        return (0, r.jsxs)("div", {
          className: "flex items-center justify-end space-x-2 cursor-pointer absolute bottom-0 right-0 w-96 transform-gpu transition-transform duration-300 ease-in-out",
          onClick: n,
          style: o,
          children: [(0, r.jsx)("span", {
            className: ce()("text-sm", {"text-white font-semibold": i, "text-gray-600": !i}),
            children: t
          }), (0, r.jsx)("div", {
            className: ce()("w-10 h-10 rounded-full mb-1 flex items-center justify-center", {
              "bg-gray-700": !i,
              "bg-gray-200": i
            }), children: a
          })]
        })
      }, at = function () {
        var e = (0, Ue.Z)(), t = e.showMapLayers, n = e.setMapLayer, s = e.mapLayer, i = e.toggleMapLayers,
          o = (0, a.useCallback)((function (e) {
            return function () {
              n(s !== e ? e : null)
            }
          }), [s, n]), l = [{
            title: "Default",
            id: "default",
            icon: (0, r.jsx)(nt, {className: "text-green-500 w-5 h-5"})
          }, {
            title: "Transmit Scales",
            id: "rewardScale",
            icon: (0, r.jsx)(nt, {className: "text-reward-scale-0.6 w-5 h-5"})
          }, {title: "Earnings", id: "earnings", icon: (0, r.jsx)(nt, {className: "text-earnings-scale-0.9 w-5 h-5"})}];
        return (0, r.jsx)("div", {
          className: ce()("fixed right-0 bottom-8 md:bottom-0 p-4 md:p-8 md:pr-4 transform-gpu transition-all duration-300 ease-in-out", {"opacity-0 pointer-events-none": !t}),
          children: (0, r.jsxs)("div", {
            className: "relative",
            children: [(0, r.jsx)("div", {
              onClick: i,
              className: "cursor-pointer w-10 h-10 flex items-center justify-center self-end transform-gpu transition-transform duration-300 ease-in-out",
              style: {transform: t ? "translateY(-".concat(50 * l.length, "px)") : "translateY(0)"},
              children: (0, r.jsx)("img", {alt: "", src: "/images/close.svg"})
            }), l.map((function (e, n) {
              var a = e.title, i = e.id, l = e.icon;
              return (0, r.jsx)(rt, {
                title: a,
                icon: l,
                onClick: o(i),
                active: s === i,
                style: {transform: t ? "translateY(-".concat(50 * n, "px)") : "translateY(0)"}
              }, i)
            }))]
          })
        })
      }, st = n(64593), it = n(49946), ot = function (e) {
        var t = e.breadcrumbs, n = (0, i.$B)().url, a = t || function (e) {
          var t = e.split("/"), n = [];
          return t.map((function (e, t, r) {
            var a = r.length;
            return 0 !== t && t < a - 1 && n.push({title: (0, c.startCase)(e), path: "/".concat(e)}), null
          })), n
        }(n);
        return (0, r.jsx)("div", {
          className: "flex flex-row items-center justify-start",
          children: a && a.length > 0 && a.map((function (e, t) {
            return (0, r.jsxs)("span", {
              className: "pointer-events-auto flex flex-row items-center justify-start pb-1",
              children: [(0, r.jsx)(o.Link, {
                className: "text-gray-600 font-sans text-xs md:text-sm font-semibold hover:text-gray-200",
                to: e.path,
                children: e.title
              }), (0, r.jsx)("p", {
                className: "text-gray-700 opacity-30 mx-2 my-0 font-bold text-md font-sans",
                children: "|"
              })]
            }, "".concat(t, "-").concat(e.title))
          }))
        })
      }, lt = (0, a.memo)(ot), ct = function (e) {
        var t = e.textToCopy, n = e.tooltip, s = e.className, i = e.iconClasses, o = e.children, l = (0, a.useState)(!1),
          c = l[0], u = l[1];
        (0, a.useEffect)((function () {
          var e = null === window || void 0 === window ? void 0 : window.setTimeout((function () {
            u(!1)
          }), 1500);
          return function () {
            return null === window || void 0 === window ? void 0 : window.clearTimeout(e)
          }
        }), [c]);
        var d = function (e) {
          navigator.clipboard ? navigator.clipboard.writeText(e).then((function () {
            u(!0)
          }), (function (e) {
            u(!1), console.error("Unable to copy", e)
          })) : function (e) {
            if (document) {
              var t = document.createElement("textarea");
              t.value = e, t.style.top = "0", t.style.left = "0", t.style.position = "fixed", document.body.appendChild(t), t.focus(), t.select();
              try {
                var n = document.execCommand("copy");
                u(n)
              } catch (r) {
                u(!1), console.error("Unable to copy", r)
              }
              document.body.removeChild(t)
            }
          }(e)
        };
        return t ? (0, r.jsx)(r.Fragment, {
          children: (0, r.jsx)("span", {
            className: "relative inline-block", onClick: function () {
              return d(t)
            }, children: (0, r.jsxs)("span", {
              className: "relative inline-flex items-center justify-between",
              children: [(0, r.jsx)("span", {
                className: ce()({"mr-2": !s}, s),
                children: o
              }), (0, r.jsx)("span", {
                className: "flex-1",
                children: c ? (0, r.jsx)("svg", {
                  xmlns: "http://www.w3.org/2000/svg",
                  className: ce()("inline-block text-green-500", {"h-4 w-auto": !i}, i),
                  fill: "none",
                  viewBox: "0 0 24 24",
                  stroke: "currentColor",
                  children: (0, r.jsx)("path", {
                    strokeLinecap: "round",
                    strokeLinejoin: "round",
                    strokeWidth: 2,
                    d: "M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-6 9l2 2 4-4"
                  })
                }) : (0, r.jsx)(fe.Z, {
                  title: n,
                  children: (0, r.jsx)("svg", {
                    xmlns: "http://www.w3.org/2000/svg",
                    className: ce()("inline-block text-gray-600 cursor-pointer", {"h-4 w-auto": !i}, i),
                    fill: "none",
                    viewBox: "0 0 24 24",
                    stroke: "currentColor",
                    children: (0, r.jsx)("path", {
                      strokeLinecap: "round",
                      strokeLinejoin: "round",
                      strokeWidth: 2,
                      d: "M8 5H6a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2v-1M8 5a2 2 0 002 2h2a2 2 0 002-2M8 5a2 2 0 012-2h2a2 2 0 012 2m0 0h2a2 2 0 012 2v3m2 4H10m0 0l3-3m-3 3l3 3"
                    })
                  })
                })
              })]
            })
          })
        }) : (0, r.jsx)("span", {className: s, children: o})
      }, ut = function (e) {
        var t = e.subtitle, n = (0, r.jsx)(ct, {
          className: ce()("text-shadow tracking-tighter text-xs md:text-sm", {"mr-1 md:mr-1.5": null === t || void 0 === t ? void 0 : t.textToCopy}),
          iconClasses: "h-2.5 md:h-3.5 w-auto",
          textToCopy: t.textToCopy,
          children: t.title
        });
        return (0, r.jsx)(fe.Z, {
          title: t.tooltip,
          placement: "bottom",
          children: (0, r.jsxs)("span", {
            className: "pointer-events-auto inline-flex items-center justify-start",
            children: [t.iconPath && (0, r.jsx)("img", {
              alt: "",
              src: t.iconPath,
              className: "h-2.5 md:h-3.5 w-auto mr-0.5 md:mr-1"
            }), t.icon && (0, r.jsx)("div", {
              className: ce()(null === t || void 0 === t ? void 0 : t.iconClasses),
              children: t.icon
            }), t.loading && (0, r.jsx)(dt, {
              seeThrough: !0,
              skeletonClasses: t.skeletonClasses
            }), !t.loading && (0, r.jsx)(r.Fragment, {
              children: t.path ? (0, r.jsx)(o.Link, {
                className: "ml-0.5 text-white font-regular font-sans whitespace-nowrap text-xs sm:text-sm md:text-md",
                to: t.path,
                children: n
              }) : (0, r.jsx)("span", {
                className: "ml-0.5 text-white font-regular font-sans whitespace-nowrap text-xs sm:text-sm md:text-md",
                children: n
              })
            })]
          })
        })
      }, dt = function (e) {
        var t = e.seeThrough, n = e.skeletonClasses;
        return (0, r.jsx)("span", {
          className: ce()("flex items-center justify-start", n, {"opacity-25": t, "w-20": !n}),
          children: (0, r.jsx)(me, {className: "my-0 w-full h-4 md:h-5", defaultSize: !1})
        })
      }, ft = function (e) {
        var t = e.subtitles;
        return t ? t.length > 0 && (0, r.jsx)("div", {
          className: "pt-1.5 space-y-1 inline-block",
          children: t.map((function (e, t) {
            return (0, r.jsx)("div", {
              className: "w-full flex flex-row items-center justify-start space-x-2 md:space-x-3",
              children: e.map((function (e, t) {
                return (0, r.jsx)(ut, {subtitle: e}, "".concat(t, "-").concat(e.title))
              }))
            }, t)
          }))
        }) : null
      }, mt = (0, a.memo)(ft), ht = function (e) {
        var t = e.className;
        return (0, r.jsx)("svg", {
          xmlns: "http://www.w3.org/2000/svg",
          className: t,
          fill: "none",
          viewBox: "0 0 24 24",
          stroke: "currentColor",
          children: (0, r.jsx)("path", {
            strokeLinecap: "round",
            strokeLinejoin: "round",
            strokeWidth: 2,
            d: "M5 15l7-7 7 7"
          })
        })
      }, pt = function (e) {
        var t = e.title, n = e.metaTitle, a = e.description, s = e.children, i = e.breadcrumbs, o = e.subtitles,
          c = (0, it.Z)(), u = c.showInfoBox, d = c.toggleInfoBox;
        return (0, r.jsxs)("div", {
          className: ce()("fixed left-0 z-20 bottom-0 md:top-0 md:m-auto w-full md:w-120 flex flex-col items-center justify-end transform-gpu transition-all duration-200 ease-in-out h-screen", {
            "translate-y-120p md:-translate-x-full md:translate-y-0": !u,
            "translate-y-0": u
          }),
          children: [(0, r.jsx)(st.q, {children: (0, r.jsx)("title", {children: n ? "".concat(n, " \u2014 Helium Explorer") : "Helium Explorer"})}), (0, r.jsxs)("div", {
            className: "w-full md:h-screen h-full flex flex-col items-end justify-end md:justify-start max-h-90p md:max-h-screen relative",
            children: [(0, r.jsx)("div", {id: "portal-destination"}), (0, r.jsxs)("div", {
              className: "flex mt-20 md:mt-0 justify-between w-full p-4 rounded-t-2xl md:rounded-none titlebox-blur md:pt-28",
              children: [(0, r.jsxs)("div", {
                className: "flex flex-col items-start justify-start",
                children: [(0, r.jsx)(lt, {breadcrumbs: i}), (0, r.jsx)("span", {
                  className: "pointer-events-auto text-white text-2xl md:text-3xl font-semibold font-sans tracking-tight",
                  children: t
                }), (0, r.jsx)("span", {className: "", children: a}), (0, r.jsx)(mt, {subtitles: o})]
              }), (0, r.jsx)("div", {
                className: "relative md:hidden",
                style: {minWidth: 30, minHeight: 30},
                onClick: d,
                children: (0, r.jsx)(l.default, {
                  src: "/images/circle-arrow.svg",
                  className: ce()("pointer-events-auto md:transform md:rotate-90 cursor-pointer", {"md:-rotate-90": !u}),
                  width: 30,
                  height: 30
                })
              })]
            }), (0, r.jsx)("div", {
              className: ce()("pointer-events-auto flex w-full md:h-full md:max-h-full overflow-hidden max-h-[650px]", {
                "h-[70%]": o,
                "h-[78%]": !o
              }),
              children: (0, r.jsx)("div", {
                className: ce()("bg-white w-full flex flex-col overflow-mask-fix md:h-full infoboxshadow relative"),
                children: s
              })
            }), (0, r.jsx)("div", {
              className: "fixed hidden md:flex pointer-events-auto cursor-pointer right-0 top-28 button-blur items-center justify-center h-14 w-5 rounded-r-md -mr-5",
              onClick: d,
              children: (0, r.jsx)(ht, {className: ce()("h-2.5 w-2.5 text-gray-525", {"rotate-90": !u, "-rotate-90": u})})
            })]
          })]
        })
      }, xt = n(29009), vt = n(52449), gt = n(75358), yt = n(18870), jt = n(14888), wt = n(45605), bt = function (e) {
        var t = e.value, n = e.initial, a = e.type, s = e.isLoading, i = void 0 !== s && s, o = e.changeSuffix;
        if (i) return (0, r.jsx)(me, {className: "w-1/3"});
        if (t === n) return (0, r.jsx)("span", {className: "text-gray-550", children: "No Change"});
        var l = Nt[a](t, n);
        if (l === 1 / 0) return (0, r.jsx)("span", {className: "text-gray-550", children: "No Prior Data"});
        var c = l.toLocaleString(void 0, kt[a]);
        return (0, r.jsxs)("div", {
          className: ce()("text-sm font-medium", {
            "text-green-500": l > 0,
            "text-navy-400": l < 0
          }), children: [l > 0 ? "+" : "", c, o && o]
        })
      }, kt = {difference: void 0, default: void 0, percent: {style: "percent", maximumFractionDigits: 3}}, Nt = {
        difference: function (e, t) {
          return e - t
        }, percent: function (e, t) {
          return (e - t) / t
        }
      }, St = (0, a.memo)(bt), Ct = n(73727), Lt = function (e) {
        var t = e.active, n = e.payload;
        return t && n && n.length ? (0, r.jsx)("div", {
          className: "bg-white opacity-90 px-2 py-1",
          children: (0, r.jsx)("p", {
            className: "text-sm font-sans font-medium text-darkgray-800",
            children: n[0].value.toLocaleString()
          })
        }) : null
      }, Tt = function (e) {
        var t, n, a, s = e.title, i = e.tooltip, o = e.series, u = e.valuePrefix, d = e.valueSuffix, f = e.changeInitial,
          m = void 0 === f ? "first" : f, h = e.changeSuffix, p = e.locale, x = e.toLocaleStringOpts,
          v = void 0 === x ? {} : x, g = e.changeType, y = void 0 === g ? "difference" : g, j = e.isLoading,
          w = void 0 !== j && j, b = e.periodLabel, k = void 0 === b ? "30 Day Trend" : b, N = e.linkTo,
          S = o && o.length > 1 ? null === (t = o[(null === o || void 0 === o ? void 0 : o.length) - 2]) || void 0 === t ? void 0 : t.value : 0,
          C = "second_last" === m ? S : (null === (n = (0, c.first)(o || [])) || void 0 === n ? void 0 : n.value) || 0,
          L = (null === (a = (0, c.last)(o || [])) || void 0 === a ? void 0 : a.value) || 0, T = (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsxs)("div", {
              children: [(0, r.jsxs)("div", {
                className: "text-gray-600 text-sm whitespace-nowrap flex space-x-1 items-center",
                children: [(0, r.jsx)("span", {children: s}), i && (0, r.jsx)("div", {
                  className: "text-gray-600 text-sm cursor-pointer flex",
                  children: (0, r.jsx)(fe.Z, {title: i, children: (0, r.jsx)(wt.Z, {})})
                })]
              }), (0, r.jsx)("div", {
                className: "text-3xl font-medium my-1.5 tracking-tight text-black",
                children: w ? (0, r.jsx)(me, {className: "w-full my-4"}) : [u, L.toLocaleString(p, v), d].join("")
              }), (0, r.jsx)(St, {value: L, initial: C, changeSuffix: h, type: y, isLoading: w})]
            }), (0, r.jsxs)("div", {
              className: ce()("flex-1 p-4 pr-0 relative", {"cursor-pointer": N}),
              style: {maxWidth: 278},
              children: [(0, r.jsx)(xt.h, {
                width: "99%",
                aspect: 4,
                height: "100%",
                children: (0, r.jsxs)(vt.w, {
                  width: 300,
                  height: 100,
                  data: o,
                  style: N ? {cursor: "pointer"} : {},
                  children: [(0, r.jsx)(gt.B, {hide: !0, domain: [C, L]}), (0, r.jsx)(yt.x, {
                    type: "monotone",
                    dataKey: "value",
                    stroke: "#474DFF",
                    strokeWidth: 3,
                    dot: !1
                  }), !N && (0, r.jsx)(jt.u, {content: (0, r.jsx)(Lt, {})})]
                })
              }), (0, r.jsx)("div", {className: "absolute right-4 bottom-0 text-gray-550 text-xs", children: k})]
            }), N && (0, r.jsx)("div", {
              className: "flex",
              style: {width: 14},
              children: (0, r.jsx)(l.default, {src: "/images/details-arrow.svg", width: 14, height: 14})
            })]
          });
        return N ? (0, r.jsx)(Ct.Link, {
          to: N,
          className: "bg-gray-200 p-3 rounded-lg col-span-2 flex hover:bg-gray-300",
          children: T
        }) : (0, r.jsx)("div", {className: "bg-gray-200 p-3 rounded-lg col-span-2 flex", children: T})
      }, Pt = function (e) {
        var t = e.className;
        return (0, r.jsx)("svg", {
          xmlns: "http://www.w3.org/2000/svg",
          fill: "none",
          viewBox: "0 0 24 24",
          stroke: "currentColor",
          className: t,
          children: (0, r.jsx)("path", {
            strokeLinecap: "round",
            strokeLinejoin: "round",
            strokeWidth: 2,
            d: "M10 6H6a2 2 0 00-2 2v10a2 2 0 002 2h10a2 2 0 002-2v-4M14 4h6m0 0v6m0-6L10 14"
          })
        })
      }, At = function (e) {
        var t = e.title, n = e.tooltip, a = e.value, s = e.emptyValue, i = void 0 !== s && s, o = e.copyableValue,
          c = e.change, u = e.changeSuffix, d = e.valueSuffix, f = e.valueIsText, m = void 0 !== f && f, h = e.subtitle,
          p = e.longSubtitle, x = void 0 !== p && p, v = e.onClick, g = e.icon, y = e.span, j = void 0 === y ? 1 : y,
          w = e.isLoading, b = void 0 !== w && w, k = e.linkTo, N = e.className, S = e.titleIcon,
          C = k && /^https?:\/\//.test(k), L = (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsxs)("div", {
              className: "w-full text-gray-800",
              children: [(0, r.jsxs)("div", {
                className: "flex items-center space-x-1",
                children: [S, b && !t && (0, r.jsx)(me, {className: "w-1/5"}), t && (0, r.jsx)("div", {
                  className: "text-gray-600 text-sm",
                  children: t
                }), n && (0, r.jsx)("div", {
                  className: "text-gray-600 text-sm cursor-pointer flex",
                  children: (0, r.jsx)(fe.Z, {title: n, children: (0, r.jsx)(wt.Z, {})})
                })]
              }), (0, r.jsxs)("div", {
                className: "flex items-center",
                children: [g && (0, r.jsx)("div", {
                  className: "mr-1.5 flex items-center",
                  children: g
                }), (0, r.jsx)("div", {
                  className: "text-2xl font-medium text-black my-1.5 tracking-tight w-full break-all",
                  children: b ? (0, r.jsx)(me, {className: "w-full"}) : (0, r.jsx)(ct, {
                    textToCopy: o,
                    children: (0, r.jsx)("p", {
                      className: ce()("flex items-center m-0 p-0", {
                        "cursor-pointer hover:text-gray-800 transition-all duration-150": o,
                        "text-gray-400 text-md font-light": i
                      }),
                      children: (0, r.jsxs)("span", {className: m ? "break-normal" : "break-all", children: [a, d && d]})
                    })
                  })
                })]
              }), c && (b ? (0, r.jsx)(me, {className: "w-1/4"}) : (0, r.jsxs)("div", {
                className: ce()("text-sm font-medium", {
                  "text-green-500": c > 0,
                  "text-navy-400": c < 0
                }), children: [c > 0 ? "+" : "", c, u]
              })), h && b ? (0, r.jsx)(me, {className: "w-1/3"}) : (0, r.jsx)("span", {
                className: ce()({"text-sm leading-tight": x}),
                children: h
              })]
            }), (v || k) && (0, r.jsx)("div", {
              className: "flex items-center justify-center",
              children: C ? (0, r.jsx)(Pt, {className: "w-4 h-4 text-gray-525"}) : (0, r.jsx)(l.default, {
                src: "/images/details-arrow.svg",
                width: 14,
                height: 14
              })
            })]
          });
        return C ? (0, r.jsx)("a", {
          href: k,
          target: "_blank",
          rel: "noopener noreferrer",
          className: ce()("bg-gray-200 p-3 rounded-lg flex transition-all cursor-pointer hover:bg-gray-300", {
            "col-span-1": 1 === j,
            "col-span-2": 2 === j
          }, N),
          children: L
        }) : k ? (0, r.jsx)(Ct.Link, {
          className: ce()("bg-gray-200 p-3 rounded-lg flex transition-all cursor-pointer hover:bg-gray-300", {
            "col-span-1": 1 === j,
            "col-span-2": 2 === j
          }, N), to: k, onClick: v, children: L
        }) : (0, r.jsx)("div", {
          className: ce()("bg-gray-200 p-3 rounded-lg flex transition-all", {
            "col-span-1": 1 === j,
            "col-span-2": 2 === j,
            "cursor-pointer hover:bg-gray-300": !!v
          }, N), onClick: v, children: L
        })
      }, Mt = {difference: void 0, default: void 0, percent: {style: "percent", maximumFractionDigits: 3}},
      _t = function (e) {
        var t, n, a, s = e.title, i = e.series, o = e.isLoading, l = void 0 !== o && o, u = e.dataKey,
          d = void 0 === u ? "value" : u, f = e.valueType, m = void 0 === f ? "default" : f, h = e.changeType,
          p = void 0 === h ? "difference" : h, x = e.changeInitial, v = void 0 === x ? "first" : x, g = e.linkTo,
          y = e.span, j = void 0 === y ? 1 : y, w = e.valueSuffix, b = e.changeSuffix,
          k = i && i.length > 1 ? null === (t = i[i.length - 2]) || void 0 === t ? void 0 : t[d] : 0,
          N = null === (n = (0, c.last)(i || [])) || void 0 === n ? void 0 : n[d],
          S = "second_last" === v ? k : null === (a = (0, c.first)(i || [])) || void 0 === a ? void 0 : a[d],
          C = null === N || void 0 === N ? void 0 : N.toLocaleString(void 0, Mt[m]);
        return (0, r.jsx)(At, {
          title: s,
          value: C,
          subtitle: (0, r.jsx)(St, {value: N, initial: S, type: p, changeSuffix: b}),
          isLoading: l,
          linkTo: g,
          span: j,
          valueSuffix: w
        })
      }, Ot = n(98130), Ht = function () {
        var e = (0, a.useState)(!1), t = e[0], n = e[1];
        return t ? null : (0, r.jsx)(At, {
          title: "Countdown to Rewards Halving",
          value: (0, r.jsx)(Ot.ZP, {
            date: new Date("2021-08-01"), renderer: function (e) {
              var t = e.days, r = e.hours, a = e.minutes, s = e.seconds;
              return e.completed && n(!0), "".concat(t, "d ").concat(r, "h ").concat(a, "m ").concat(s, "s")
            }
          }),
          subtitle: (0, r.jsx)("span", {className: "text-gray-600", children: "August 1st, 2021 "}),
          span: 2,
          linkTo: "https://blog.helium.com/hip-20-on-hnt-max-supply-approved-by-the-community-fca15a161a80"
        })
      };

    function It(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function Bt(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          It(e, t, n[t])
        }))
      }
      return e
    }

    var Et = function (e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : "horizontal", n = (0, a.useState)(!1),
        r = n[0], s = n[1], i = (0, a.useState)(!0), o = i[0], l = i[1], c = (0, a.useState)(!0), u = c[0], d = c[1],
        f = (0, a.useState)(), m = f[0], h = f[1], p = (0, a.useState)(), x = p[0], v = p[1], g = (0, a.useState)(),
        y = g[0], j = g[1], w = (0, a.useState)(), b = w[0], k = w[1], N = (0, a.useState)(), S = N[0], C = N[1],
        L = (0, a.useState)(), T = L[0], P = L[1], A = (0, a.useCallback)((function () {
          var n, r, a, i, o, c;
          "horizontal" === t ? (h(null === e || void 0 === e || null === (n = e.current) || void 0 === n ? void 0 : n.scrollWidth), v(null === e || void 0 === e || null === (r = e.current) || void 0 === r ? void 0 : r.clientWidth), j(null === e || void 0 === e || null === (a = e.current) || void 0 === a ? void 0 : a.scrollLeft), s(m > x), d(y + 20 >= m - x), l(y < 20)) : (k(null === e || void 0 === e || null === (i = e.current) || void 0 === i ? void 0 : i.scrollHeight), C(null === e || void 0 === e || null === (o = e.current) || void 0 === o ? void 0 : o.clientHeight), P(null === e || void 0 === e || null === (c = e.current) || void 0 === c ? void 0 : c.scrollTop), s(b > S), d(T + 30 >= b - S), l(T < 20))
        }), [t, e, b, y, T, m, S, x]), M = function (t) {
          var n, r = t.direction, a = void 0 === r ? "right" : r, s = t.distanceInPixels, i = void 0 === s ? 100 : s,
            o = t.distanceInPercentOfContainer, l = void 0 === o ? 25 : o;
          l ? n = ("left" === a || "right" === a ? m * l : b * l) / 100 : n = i;
          var c = {};
          "left" === a ? c.left = -n : "right" === a ? c.left = n : "up" === a ? c.top = -n : "down" === a && (c.top = n), e.current.scrollBy(Bt({}, c, {behavior: "smooth"}))
        };
      return (0, a.useEffect)((function () {
        (null === e || void 0 === e ? void 0 : e.current) && (e.current.style.position = "relative"), A()
      }), [e, A]), {autoScroll: M, isScrollable: r, isScrolledToStart: o, updateScrollIndicators: A, isScrolledToEnd: u}
    }, Ft = function (e) {
      var t = e.className, n = e.wrapperClasses, a = e.onClick, s = e.shown, i = e.direction,
        o = void 0 === i ? "right" : i;
      return (0, r.jsx)("div", {
        className: ce()(n, "absolute cursor-pointer transform-gpu transition-all duration-200", {
          "opacity-100 pointer-events-auto": s,
          "opacity-0 pointer-events-none": !s,
          "right-0 top-0 h-full": "right" === o,
          "left-0 top-0 h-full": "left" === o,
          "left-0 right-0 bottom-0 w-full": "down" === o,
          "left-0 right-0 top-0 w-full": "up" === o
        }),
        onClick: a,
        children: (0, r.jsx)("div", {
          className: ce()("flex items-center justify-center from-white via-white", {
            "w-8 h-full": "right" === o || "left" === o,
            "w-full h-8": "up" === o || "down" === o,
            "bg-gradient-to-l": "right" === o,
            "bg-gradient-to-r": "left" === o,
            "bg-gradient-to-t": "down" === o,
            "bg-gradient-to-b": "up" === o
          }, t),
          children: (0, r.jsx)("span", {
            className: ce()({
              "animate-bounce-right": "right" === o,
              "animate-bounce-left ": "left" === o,
              "animate-bounce": "down" === o || "up" === o
            }),
            children: (0, r.jsx)(ht, {
              className: ce()("w-4 h-4 text-navy-400 opacity-75", {
                "rotate-90": "right" === o,
                "-rotate-90": "left" === o,
                "rotate-180": "down" === o
              })
            })
          })
        })
      })
    }, Dt = function (e) {
      var t = e.children, n = e.className, s = e.span, i = void 0 === s ? 2 : s, o = e.padding, l = void 0 === o || o,
        c = (0, a.useRef)(null), u = Et(c, "vertical"), d = u.autoScroll, f = u.isScrollable, m = u.isScrolledToEnd,
        h = u.updateScrollIndicators;
      return (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsxs)("div", {
          className: ce()("grid grid-flow-row relative overflow-y-scroll no-scrollbar", n, {
            "grid-cols-1": 1 === i,
            "grid-cols-2 gap-3 md:gap-4": 2 === i,
            "pt-4 px-4 md:pt-8 md:px-8": l
          }), onScroll: h, ref: c, children: [t, (0, r.jsx)("div", {className: "pt-1.5 md:pt-4 px-1 col-span-2"})]
        }), (0, r.jsx)(Ft, {
          direction: "down", onClick: function () {
            return d({direction: "down"})
          }, shown: f && !m
        })]
      })
    }, Zt = function (e) {
      var t = e.value, n = e.isLarge;
      if (!t) return "$0.00";
      if (void 0 !== n && n) {
        var r = 1e9, a = 1e6;
        if (t >= r) return ["$", (0, c.round)(t / r, 3), "B"].join("");
        if (t >= a) return ["$", (0, c.round)(t / a, 3), "M"].join("")
      }
      return t.toLocaleString("en-US", {
        style: "currency",
        currency: "USD",
        minimumFractionDigits: 2,
        maximumFractionDigits: 2
      })
    }, Rt = n(8100), Gt = n(73303), Vt = n.n(Gt);

    function Wt(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Ut = function () {
      var e, t = (e = f().mark((function e() {
        var t, n;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, fetch("https://api.coingecko.com/api/v3/coins/helium");
            case 2:
              return t = e.sent, e.next = 5, t.json();
            case 5:
              return n = e.sent, e.abrupt("return", {
                volume: Vt()(n.tickers, "converted_volume.usd"),
                price: n.market_data.current_price.usd,
                priceChange: n.market_data.price_change_percentage_24h
              });
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            Wt(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Wt(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      });
      return function () {
        return t.apply(this, arguments)
      }
    }(), zt = function (e) {
      var t = (0, Rt.ZP)("market", Ut, {initialData: e, refreshInterval: 1e4}), n = t.data, r = t.error;
      return {market: n, isLoading: !r && !n, isError: r}
    };

    function Kt(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function qt(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            Kt(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Kt(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    var $t = function () {
      var e = qt(f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.stats.get();
            case 2:
              return t = e.sent, e.abrupt("return", {
                circulatingSupply: t.tokenSupply,
                blockTime: t.blockTimes.lastDay.avg,
                blockTimes: t.blockTimes,
                challenges: t.counts.challenges,
                consensusGroups: t.counts.consensusGroups,
                electionTime: t.electionTimes.lastDay.avg,
                electionTimes: t.electionTimes,
                totalHotspots: t.counts.hotspots,
                totalBlocks: t.counts.blocks,
                totalCities: t.counts.cities,
                totalCountries: t.counts.countries
              });
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function () {
        return e.apply(this, arguments)
      }
    }(), Jt = function (e) {
      var t = (0, Rt.ZP)("stats", $t, {initialData: e, refreshInterval: 1e4}), n = t.data, r = t.error;
      return {stats: n, isLoading: !r && !n, isError: r}
    };
    (function () {
      var e = qt(f().mark((function e() {
        var t, n = arguments;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return t = n.length > 0 && void 0 !== n[0] ? n[0] : 20, e.next = 3, m.ZP.cities.list({order: "onlineCount"});
            case 3:
              return e.abrupt("return", e.sent.take(t));
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })))
    })(), function () {
      var e = qt(f().mark((function e() {
        var t, n = arguments;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return t = n.length > 0 && void 0 !== n[0] ? n[0] : 20, e.next = 3, m.ZP.cities.list({order: "hotspotCount"});
            case 3:
              return e.abrupt("return", e.sent.take(t));
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })))
    }();

    function Yt(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Xt = function () {
      var e, t = (e = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.stats.dcBurns();
            case 2:
              return t = e.sent, e.abrupt("return", {totalWeek: t.lastWeek.total, totalMonth: t.lastMonth.total});
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            Yt(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Yt(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      });
      return function () {
        return t.apply(this, arguments)
      }
    }(), Qt = n(52572);

    function en(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function tn(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function nn(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            tn(s, r, a, i, o, "next", e)
          }

          function o(e) {
            tn(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function rn(e) {
      return function (e) {
        if (Array.isArray(e)) return en(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return en(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return en(e, t)
      }(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var an = function () {
      var e = nn(f().mark((function e(t) {
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.abrupt("return", m.ZP.validators.get(t));
            case 1:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), sn = function (e) {
      var t, n = "validators/".concat(e), r = (0, Rt.ZP)(n, (t = e, function () {
        return an(t)
      }), {refreshInterval: 6e4}), a = r.data, s = r.error;
      return {validator: a, isLoading: !s && !a, isError: s}
    }, on = function () {
      var e = nn(f().mark((function e(t) {
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.account(t).validators.list();
            case 2:
              return e.abrupt("return", e.sent.take(m.pA));
            case 3:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), ln = function () {
      var e = nn(f().mark((function e() {
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.abrupt("return", m.ZP.validators.stats.get());
            case 1:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function () {
        return e.apply(this, arguments)
      }
    }(), cn = function () {
      var e = (0, Rt.ZP)("validators/stats", (function () {
        return ln()
      }), {refreshInterval: 6e4}), t = e.data, n = e.error;
      return {stats: t, isLoading: !n && !t, isError: n}
    }, un = function () {
      var e, t, n, a, s, i = (0, L.ZP)("/metrics/hotspots").data, o = (0, L.ZP)("/metrics/blocks").data, l = cn().stats,
        u = zt().market, d = Jt().stats, f = function (e) {
          var t = (0, Rt.ZP)("dataCredits", Xt, {initialData: e, refreshInterval: 1e4}), n = t.data, r = t.error;
          return {dataCredits: n, isLoading: !r && !n, isError: r}
        }().dataCredits;
      return (0, r.jsx)(pt, {
        title: (0, r.jsx)("div", {
          className: "pt-4 lg:pt-10 lg:px-5",
          children: (0, r.jsxs)("span", {
            className: "text-white text-2xl md:text-3xl font-light font-sans tracking-tight",
            children: ["Welcome to", " ", (0, r.jsx)("p", {
              className: "font-semibold leading-5",
              children: "Helium Explorer"
            })]
          })
        }),
        description: (0, r.jsx)("div", {
          className: "w-full py-4 lg:px-5",
          children: (0, r.jsxs)("span", {
            className: "text-white font-sans font-light text-lg tracking-tight leading-tight",
            children: ["Helium Explorer is a Block Explorer and Analytics Platform for", " ", (0, r.jsx)("a", {
              href: "https://helium.com",
              rel: "noopener noreferrer",
              target: "_blank",
              className: "text-green-450 underline",
              children: "Helium"
            }), ", a decentralized wireless connectivity platform."]
          })
        }),
        children: (0, r.jsxs)(Dt, {
          children: [(0, r.jsx)(Tt, {
            title: "Hotspots",
            series: null === i || void 0 === i ? void 0 : i.count,
            isLoading: !i,
            linkTo: "/hotspots"
          }), (0, r.jsx)(_t, {
            title: "Block Height",
            series: null === o || void 0 === o ? void 0 : o.height,
            isLoading: !o,
            linkTo: "/blocks"
          }), (0, r.jsx)(At, {
            title: "Market Price",
            tooltip: "Based on data provided by CoinGecko",
            value: (0, r.jsx)(Zt, {value: null === u || void 0 === u ? void 0 : u.price}),
            change: (0, c.round)(null === u || void 0 === u ? void 0 : u.priceChange, 2),
            changeSuffix: "%",
            isLoading: !u,
            linkTo: "/market"
          }), (0, r.jsx)(At, {
            title: "DC Spent (30d)",
            tooltip: "Data Credits are spent for transaction fees and to send data over the Helium Network. HNT are burned to create DC.",
            value: (Math.abs(Number(null === f || void 0 === f ? void 0 : f.totalMonth)) / 1e9).toFixed(2) + " bn",
            change: (0, r.jsx)(Zt, {value: 1e-5 * (null === f || void 0 === f ? void 0 : f.totalMonth)}),
            isLoading: !f,
            linkTo: "/market"
          }), (0, r.jsx)(At, {
            title: "HNT Staked",
            tooltip: "The amount of HNT being staked by Validators",
            value: Z(null === l || void 0 === l || null === (e = l.staked) || void 0 === e ? void 0 : e.amount),
            change: (0, r.jsx)(Zt, {value: (null === u || void 0 === u ? void 0 : u.price) * (null === l || void 0 === l || null === (t = l.staked) || void 0 === t ? void 0 : t.amount)}),
            isLoading: !u || !l,
            linkTo: "/validators"
          }), (0, r.jsx)(Ht, {}), (0, r.jsx)(At, {
            title: "Total Beacons",
            value: null === d || void 0 === d || null === (n = d.challenges) || void 0 === n ? void 0 : n.toLocaleString(),
            isLoading: !d,
            linkTo: "/beacons"
          }), (0, r.jsx)(At, {
            title: "Staked Validators",
            value: null === l || void 0 === l || null === (a = l.staked) || void 0 === a || null === (s = a.count) || void 0 === s ? void 0 : s.toLocaleString(),
            isLoading: !l,
            linkTo: "/validators"
          })]
        })
      })
    };

    function dn(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function fn(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          dn(e, t, n[t])
        }))
      }
      return e
    }

    var mn = function (e) {
      var t = e.title, n = e.classes, s = e.activeClasses, i = e.activeStyles, o = e.active, l = void 0 !== o && o,
        c = e.changelogIndicator, u = e.href, d = n || s || i, f = (0, a.useRef)(null);
      (0, a.useEffect)((function () {
        l && f.current.scrollIntoView({behavior: "smooth", block: "end", inline: "nearest"})
      }), [l, f]);
      var m = {scrollMargin: 52};
      return (0, r.jsxs)(Ct.Link, fn({to: u}, l ? {ref: f} : {}, {
        className: ce()(n, l ? s : "", "mx-2 py-2 lg:py-3 inline-block font-medium text-sm md:text-base cursor-pointer whitespace-nowrap relative", {
          "text-gray-600 hover:text-navy-400": !l && !d,
          "text-navy-400 border-navy-400 border-b-3 border-solid": l && !d
        }), style: l ? fn({}, i, m) : m, children: [c, t]
      }))
    }, hn = function (e) {
      return e.children
    }, pn = function (e) {
      var t = e.centered, n = void 0 !== t && t, s = e.className, o = e.htmlTitleRoot, l = e.children,
        u = (0, a.useRef)(null), d = Et(u), f = d.autoScroll, m = d.isScrollable, h = d.isScrolledToStart,
        p = d.isScrolledToEnd, x = d.updateScrollIndicators, v = (0, i.$B)(), g = v.path, y = v.url, j = (0, i.TH)(),
        w = (0, a.useMemo)((function () {
          return (0, c.castArray)(l).map((function (e) {
            return e ? {
              key: e.key,
              title: e.props.title,
              path: e.props.path,
              classes: e.props.classes,
              activeClasses: e.props.activeClasses,
              activeStyles: e.props.activeStyles,
              hidden: e.props.hidden,
              changelogIndicator: e.props.changelogIndicator
            } : null
          }))
        }), [l]), b = (0, a.useMemo)((function () {
          return (0, c.castArray)(l)
        }), [l]), k = (0, a.useCallback)((function (e) {
          var t = (0, i.LX)(j.pathname, {path: e ? "".concat(g, "/").concat(e) : g, exact: !0});
          return (null === t || void 0 === t ? void 0 : t.isExact) || !1
        }), [j.pathname, g]);
      return (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsxs)("div", {
          className: "w-full relative bg-white z-10",
          children: [(0, r.jsx)("div", {
            ref: u,
            onScroll: x,
            className: ce()(s, {
              "w-full border-b border-gray-400 border-solid mt-1 lg:mt-2 px-2 md:px-3 flex overflow-x-scroll no-scrollbar": !s,
              "justify-center": n,
              "justify-start": !n
            }),
            children: w.map((function (e, t, n) {
              var s = n.length;
              return e.hidden ? null : (0, r.jsxs)(a.Fragment, {
                children: [(0, r.jsx)(mn, {
                  title: e.title,
                  classes: e.classes,
                  activeClasses: e.activeClasses,
                  activeStyles: e.activeStyles,
                  active: k(e.path),
                  href: e.path ? "".concat(y, "/").concat(e.path) : y,
                  changelogIndicator: e.changelogIndicator
                }, e.key), t === s - 1 && (0, r.jsx)("div", {className: "px-2 py-2 md:px-4"})]
              }, e.key)
            }))
          }), (0, r.jsx)(Ft, {
            direction: "right",
            wrapperClasses: "pb-1",
            onClick: f,
            shown: m && !p
          }), (0, r.jsx)(Ft, {
            direction: "left", wrapperClasses: "pb-1", onClick: function () {
              return f({direction: "left"})
            }, shown: m && !h
          })]
        }), (0, r.jsx)(i.rs, {
          children: b.map((function (e) {
            return (0, r.jsxs)(i.AW, {
              exact: !0,
              path: e.props.path ? "".concat(g, "/").concat(e.props.path) : g,
              children: [(0, r.jsx)(st.q, {children: (0, r.jsx)("title", {children: "".concat(o ? "".concat(o, " \u2013 ") : "").concat(e.props.title)})}), e]
            }, e.key)
          }))
        })]
      })
    }, xn = (0, o.createI18n)(["en", "fr"], {
      en: {
        hello: "Hello",
        hotspots: {title: "Hotspots"},
        blocks: {title: "Blocks", block: "Block"},
        tooltips: {distance: "Hotspot locations are scaled up to the nearest resolution 8 hexagon and anonymized to the center of that hexagon. Distances between Hotspots are then calculated from the center of a resolution 8 hexagon that the Hotspot occupies to the other. e.g. If the distance is 0 m, it's because they are in the same hexagon."}
      }, fr: {hello: "Bonjour", hotspots: {title: "Chaudspots"}, blocks: {title: "Blocks", block: "Block"}}
    }), vn = n(3013), gn = function (e) {
      var t = e.title, n = e.iconPath;
      return (0, r.jsxs)("span", {
        className: "flex items-center justify-start",
        children: [(0, r.jsx)("img", {alt: "", src: n, className: "h-4 w-auto mr-1"}), t]
      })
    }, yn = function (e) {
      var t = e.title, n = e.titleIconPath, a = e.hotspot, s = (0, ee.Z)().selectHotspot;
      return a ? (0, r.jsx)(At, {
        title: n ? (0, r.jsx)(gn, {title: t, iconPath: n}) : t,
        value: (0, ae.$x)(a.name),
        subtitle: (0, r.jsx)(de, {geocode: a.geocode}),
        span: 2,
        linkTo: "/hotspots/".concat(a.address),
        onClick: function () {
          return s(a.address)
        }
      }) : (0, r.jsx)(At, {span: 2, isLoading: !0})
    }, jn = function () {
      var e, t = (0, L.ZP)("/metrics/hotspots").data, n = (0, L.ZP)("/makers").data, s = (0, vn.id)().latestHotspots,
        i = (0, a.useMemo)((function () {
          return s ? s.find((function (e) {
            return !!e.location
          })) : null
        }), [s]);
      return (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(Tt, {
          title: "Hotspots",
          series: null === t || void 0 === t ? void 0 : t.count,
          isLoading: !t
        }), (0, r.jsx)(_t, {
          title: "% Online",
          series: null === t || void 0 === t ? void 0 : t.onlinePct,
          isLoading: !t,
          valueType: "percent",
          changeType: "percent"
        }), (0, r.jsx)(At, {
          title: "Makers",
          value: null === n || void 0 === n ? void 0 : n.length,
          subtitle: "Latest: ".concat(null === (e = (0, c.maxBy)(n, "id")) || void 0 === e ? void 0 : e.name),
          isLoading: !n,
          linkTo: "/hotspots/makers"
        }), (0, r.jsx)(_t, {
          title: "Cities",
          series: null === t || void 0 === t ? void 0 : t.citiesCount,
          isLoading: !t
        }), (0, r.jsx)(_t, {
          title: "Countries",
          series: null === t || void 0 === t ? void 0 : t.countriesCount,
          isLoading: !t
        }), (0, r.jsx)(yn, {title: "Latest Hotspot", hotspot: i})]
      })
    }, wn = n(58117), bn = n.n(wn);

    function kn(e, t) {
      var n = "online" === e ? "Hotspot online" : "Hotspot offline";
      return t && (n = n += ": Status last updated ".concat(t.toLocaleString())), n
    }

    var Nn = function (e) {
      var t = e.status, n = void 0 === t ? {online: null, height: null} : t, a = n.online, s = n.height;
      return (0, r.jsx)(fe.Z, {
        title: kn(a, s),
        children: (0, r.jsx)("span", {
          style: {
            width: "10px",
            height: "10px",
            borderRadius: "10px",
            background: "online" === a ? "#29D391" : "#FFC769",
            display: "inline-block",
            marginRight: "6px"
          }
        })
      })
    }, Sn = n(68952), Cn = function (e) {
      var t = e.padding;
      return (0, r.jsx)("div", {
        className: ce()("w-full grid grid-cols-1", {"p-3": t}),
        children: (0, c.times)(10).map((function (e, t, n) {
          n.length;
          return (0, r.jsxs)("div", {
            className: ce()("py-2 px-4 flex border-solid border-gray-500 border-b"),
            children: [(0, r.jsxs)("div", {
              className: "w-full",
              children: [(0, r.jsx)("div", {
                className: "text-base font-medium",
                children: (0, r.jsx)(me, {className: "w-1/2"})
              }), (0, r.jsx)("div", {
                className: "flex items-center space-x-4 h-8",
                children: (0, r.jsx)(me, {className: "w-1/4"})
              })]
            }), (0, r.jsx)("div", {
              className: "flex",
              children: (0, r.jsx)(l.default, {src: "/images/details-arrow.svg", width: 10, height: 10})
            })]
          }, t)
        }))
      })
    };

    function Ln(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function Tn(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return Ln(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return Ln(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var Pn = function (e) {
      var t = e.title, n = e.description, a = Tn(We(), 2), s = a[0], i = a[1];
      return (0, r.jsxs)("div", {
        className: ce()("w-full px-4 py-2 bg-gray-200 border-b border-solid border-gray-400", {"pb-4": s}),
        children: [(0, r.jsxs)("div", {
          className: ce()("flex items-center justify-between", {"pb-2": s}),
          children: [(0, r.jsx)("span", {
            className: "font-sans text-800 font-medium text-sm md:text-base whitespace-nowrap",
            children: t
          }), n && t && (0, r.jsx)("button", {
            className: "px-2 py-0.5 bg-gray-200 focus:bg-gray-300 rounded-md border-gray-400 border-solid border outline-none focus:border-gray-400",
            onClick: i,
            children: (0, r.jsxs)("span", {
              className: "flex items-center justify-end",
              children: [(0, r.jsx)("span", {
                className: "text-xs text-gray-650 mr-1",
                children: "Details"
              }), (0, r.jsx)(ht, {
                className: ce()("text-gray-650 transform h-3 w-auto transition-all duration-200", {
                  "rotate-0": s,
                  "rotate-180": !s
                })
              })]
            })
          })]
        }), (s || n && !t) && (0, r.jsx)("span", {
          className: "font-sans text-gray-600 text-xs md:text-sm pt-1",
          children: n
        })]
      })
    }, An = function (e) {
      var t = e.padding;
      return (0, r.jsx)("div", {
        className: ce()("w-full grid grid-cols-1", {"p-3": t}),
        children: (0, c.times)(20).map((function (e, t, n) {
          n.length;
          return (0, r.jsxs)("div", {
            className: ce()("py-2 px-4 flex border-solid border-gray-500 border-b"),
            children: [(0, r.jsxs)("div", {
              className: "w-full flex flex-row items-center justify-start space-x-2",
              children: [(0, r.jsx)("div", {
                className: "h-8 w-8 rounded-full",
                children: (0, r.jsx)(me, {defaultSize: !1, defaultRounding: !1, className: "h-8 w-8 rounded-full"})
              }), (0, r.jsx)(me, {className: "w-1/3"})]
            }), (0, r.jsx)("div", {
              className: "flex",
              children: (0, r.jsx)(l.default, {src: "/images/details-arrow.svg", width: 10, height: 10})
            })]
          }, t)
        }))
      })
    };

    function Mn(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function _n(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || Hn(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    function On(e) {
      return function (e) {
        if (Array.isArray(e)) return Mn(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || Hn(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    function Hn(e, t) {
      if (e) {
        if ("string" === typeof e) return Mn(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        return "Object" === n && e.constructor && (n = e.constructor.name), "Map" === n || "Set" === n ? Array.from(n) : "Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n) ? Mn(e, t) : void 0
      }
    }

    var In = function (e) {
      var t = e.items, n = e.listHeaderTitle, s = e.listHeaderDescription, i = e.listHeaderShowCount,
        l = e.listHeaderCount, c = e.keyExtractor, u = e.linkExtractor, d = e.isLoading, f = void 0 === d || d,
        m = e.onSelectItem, h = e.renderItem, p = e.renderTitle, x = e.renderSubtitle, v = e.renderDetails,
        g = e.blankTitle, y = e.padding, j = e.fetchMore, w = e.isLoadingMore, b = e.hasMore, k = e.itemPadding,
        N = void 0 === k || k, S = e.expandableItem, C = void 0 === S ? function () {
          return !1
        } : S, L = e.defaultBaseItem, T = void 0 === L || L, P = e.isActivityList, A = void 0 !== P && P,
        M = _n((0, Sn.Z)({
          loading: w,
          hasNextPage: b,
          onLoadMore: j,
          disabled: !1,
          rootMargin: "0px 0px 400px 0px"
        }), 1)[0], _ = (0, a.useCallback)((function (e) {
          return function () {
            m && m(e)
          }
        }), [m]), O = (0, a.useCallback)((function (e, t, n) {
          var a = n.length, s = h ? h(e) : (0, r.jsxs)(r.Fragment, {
              children: [(0, r.jsxs)("div", {
                className: "w-full",
                children: [(0, r.jsx)("div", {
                  className: "text-sm md:text-base font-medium text-darkgray-800 font-sans whitespace-nowrap",
                  children: p(e)
                }), (0, r.jsx)("div", {
                  className: "flex items-center space-x-4 h-6 text-gray-525 text-xs md:text-sm whitespace-nowrap",
                  children: x(e)
                })]
              }), (0, r.jsx)("div", {
                className: "flex items-center px-4 text-xs md:text-sm font-sans text-gray-525",
                children: v(e)
              }), u && (0, r.jsx)("div", {
                className: "flex items-center",
                children: (0, r.jsx)("img", {alt: "", src: "/images/details-arrow.svg"})
              })]
            }),
            i = ["bg-white hover:bg-gray-200 focus:bg-gray-200 cursor-pointer transition-all duration-75 relative flex border-solid border-gray-500 border-b", {
              "px-4 py-2": N,
              "border-t-0": 0 !== t && t !== a - 1
            }];
          return u && !C(e) ? (0, r.jsx)(o.Link, {
            to: u(e),
            onClick: _(e),
            className: T ? ce().apply(void 0, On(i)) : "",
            children: s
          }, c(e)) : (0, r.jsx)("div", {className: T ? ce().apply(void 0, On(i)) : "", children: s}, c(e))
        }), [T, C, _, N, c, u, v, h, x, p]), H = (0, a.useMemo)((function () {
          return i ? void 0 !== l ? "".concat(n, " (").concat(l.toLocaleString(), ")") : "".concat(n, " (").concat(t.length.toLocaleString(), ")") : n
        }), [t.length, l, i, n]);
      return f ? A ? (0, r.jsx)(An, {}) : (0, r.jsx)(Cn, {}) : t && 0 === t.length ? (0, r.jsx)("div", {
        className: "flex items-center justify-center text-gray-600 py-6 text-base",
        children: g
      }) : (0, r.jsxs)("div", {
        className: ce()("w-full grid grid-cols-1", {"p-3": y}),
        children: [(n || s) && (0, r.jsx)(Pn, {title: H, description: s}), (t || []).map((function (e, t, n) {
          var r = n.length;
          return O(e, t, r)
        })), j && b && (0, r.jsx)("div", {
          ref: M,
          className: "text-center text-base text-gray-700 py-2",
          children: "Loading more..."
        })]
      })
    }, Bn = function (e) {
      var t, n = e.hotspot, a = e.icon, s = void 0 === a || a;
      return (0, r.jsx)(fe.Z, {
        title: "Antenna Gain",
        children: (0, r.jsxs)("div", {
          className: "flex items-center space-x-1",
          children: [s && (0, r.jsx)("img", {
            src: "/images/gain.svg",
            className: "h-3"
          }), (0, r.jsx)("span", {children: (t = n.gain, "".concat(t / 10, " dBi"))})]
        })
      })
    }, En = function (e) {
      var t, n = e.hotspot, a = e.icon, s = void 0 === a || a;
      return (0, r.jsx)(fe.Z, {
        title: "Elevation above ground level",
        children: (0, r.jsxs)("div", {
          className: "flex items-center space-x-1",
          children: [s && (0, r.jsx)("img", {
            src: "/images/elevation.svg",
            className: "h-4"
          }), (0, r.jsx)("span", {children: (t = n.elevation, "".concat(t, " m"))})]
        })
      })
    }, Fn = n(1449), Dn = n(28401);

    function Zn(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function Rn(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            Zn(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Zn(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function Gn(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function Vn(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          Gn(e, t, n[t])
        }))
      }
      return e
    }

    var Wn, Un = [(0, Dn.Z)(new Date("2019-08-01")), (0, Dn.Z)(new Date("2021-08-01"))],
      zn = (Gn(Wn = {}, Un[0], 5e6), Gn(Wn, Un[1], 25e5), Wn), Kn = function (e) {
        var t = e.bucket, n = e.numBack, r = new Date;
        return "day" === t ? r.setUTCHours(0, 0, 0, 0) : r.setUTCMinutes(0, 0, 0), {
          minTime: "-".concat(n, " ").concat(t),
          maxTime: r,
          bucket: t
        }
      }, qn = function () {
        var e = Rn(f().mark((function e(t, n, r) {
          var a, s, i;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                if (t) {
                  e.next = 2;
                  break
                }
                return e.abrupt("return");
              case 2:
                return a = Kn({bucket: r, numBack: n}), e.next = 5, m.ZP.hotspot(t).rewards.sum.list(a);
              case 5:
                return s = e.sent, e.next = 8, s.take(m.pA);
              case 8:
                return i = e.sent, e.abrupt("return", i.reverse());
              case 10:
              case"end":
                return e.stop()
            }
          }), e)
        })));
        return function (t, n, r) {
          return e.apply(this, arguments)
        }
      }(), $n = function () {
        var e = Rn(f().mark((function e(t, n, r) {
          var a;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                return e.next = 2, m.ZP.hotspot(t).rewards.sum.get("-".concat(n, " ").concat(r));
              case 2:
                return a = e.sent.total, e.abrupt("return", a);
              case 4:
              case"end":
                return e.stop()
            }
          }), e)
        })));
        return function (t, n, r) {
          return e.apply(this, arguments)
        }
      }(), Jn = (function () {
        var e = Rn(f().mark((function e(t, n) {
          var r, a, s;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                return r = Kn({bucket: n, numBack: t}), e.next = 3, m.ZP.rewards.sum.list(r);
              case 3:
                return e.next = 5, e.sent.take(m.pA);
              case 5:
                return a = e.sent, s = a.map((function (e) {
                  return Vn({}, e, {target: (t = e.timestamp, ((0, Dn.Z)(new Date(t)) >= Un[1] ? zn[Un[1]] : zn[Un[0]]) / 30)});
                  var t
                })), e.abrupt("return", s.reverse());
              case 8:
              case"end":
                return e.stop()
            }
          }), e)
        })))
      }(), function () {
        var e = Rn(f().mark((function e(t, n, r) {
          var a, s, i;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                if (t) {
                  e.next = 2;
                  break
                }
                return e.abrupt("return");
              case 2:
                return a = Kn({bucket: r, numBack: n}), e.next = 5, m.ZP.validator(t).rewards.sum.list(a);
              case 5:
                return s = e.sent, e.next = 8, s.take(m.pA);
              case 8:
                return i = e.sent, e.abrupt("return", i.reverse());
              case 10:
              case"end":
                return e.stop()
            }
          }), e)
        })));
        return function (t, n, r) {
          return e.apply(this, arguments)
        }
      }()), Yn = function () {
        var e = Rn(f().mark((function e(t, n, r) {
          var a, s, i;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                if (t) {
                  e.next = 2;
                  break
                }
                return e.abrupt("return");
              case 2:
                return a = Kn({bucket: r, numBack: n}), e.next = 5, m.ZP.account(t).rewards.sum.list(a);
              case 5:
                return s = e.sent, e.next = 8, s.take(m.pA);
              case 8:
                return i = e.sent, e.abrupt("return", i.reverse());
              case 10:
              case"end":
                return e.stop()
            }
          }), e)
        })));
        return function (t, n, r) {
          return e.apply(this, arguments)
        }
      }(), Xn = function (e, t) {
        var n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 30,
          r = arguments.length > 3 && void 0 !== arguments[3] ? arguments[3] : "day",
          a = "rewards/".concat(t, "s/").concat(e, "/").concat(n, "/").concat(r), s = function (e, n, r) {
            return function () {
              switch (t) {
                case"account":
                  return Yn(e, n, r);
                case"hotspot":
                  return qn(e, n, r);
                case"validator":
                  return Jn(e, n, r);
                default:
                  throw new Error("Invalid reward type")
              }
            }
          }, i = (0, Rt.ZP)(a, s(e, n, r), {refreshInterval: 6e5}), o = i.data, l = i.error;
        return {rewards: o, isLoading: !l && !o, isError: l}
      }, Qn = function () {
        var e = Rn(f().mark((function e(t, n, r) {
          var a;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                return e.next = 2, m.ZP.validator(t).rewards.sum.get("-".concat(n, " ").concat(r));
              case 2:
                return a = e.sent.total, e.abrupt("return", a);
              case 4:
              case"end":
                return e.stop()
            }
          }), e)
        })));
        return function (t, n, r) {
          return e.apply(this, arguments)
        }
      }(), er = function (e) {
        var t = function (e) {
          var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 1,
            n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : "day",
            r = "rewards/hotspots/".concat(e, "/sum/").concat(t, "/").concat(n), a = function (e, t, n) {
              return function () {
                return $n(e, t, n)
              }
            }, s = (0, Rt.ZP)(r, a(e, t, n), {refreshInterval: 0, dedupingInterval: 6e5}), i = s.data, o = s.error;
          return {rewardsSum: i, isLoading: !o && void 0 === i, isError: o}
        }(e.hotspot.address), n = t.rewardsSum;
        return t.isLoading ? (0, r.jsx)(me, {className: "w-1/4"}) : (0, r.jsx)(fe.Z, {
          title: "24h Earnings",
          children: (0, r.jsxs)("div", {
            className: "flex items-center space-x-1",
            children: [(0, r.jsx)("img", {
              src: "/images/hnt.svg",
              className: "w-3"
            }), " ", (0, r.jsxs)("span", {children: [(0, Fn.NM)(n, 2), " HNT"]})]
          })
        })
      }, tr = function (e) {
        var t = e.width, n = e.height, a = e.fillColor;
        e.className;
        return (0, r.jsx)("svg", {
          width: t || 28,
          height: n || 32,
          viewBox: "0 0 28 32",
          fill: "none",
          preserveAspectRatio: "xMinYMin meet",
          xmlns: "http://www.w3.org/2000/svg",
          children: (0, r.jsx)("path", {
            d: "M12 1.1547C13.2376 0.440169 14.7624 0.440169 16 1.1547L25.8564 6.8453C27.094 7.55983 27.8564 8.88034 27.8564 10.3094V21.6906C27.8564 23.1197 27.094 24.4402 25.8564 25.1547L16 30.8453C14.7624 31.5598 13.2376 31.5598 12 30.8453L2.14359 25.1547C0.905989 24.4402 0.143594 23.1197 0.143594 21.6906V10.3094C0.143594 8.88034 0.905989 7.55983 2.14359 6.8453L12 1.1547Z",
            fill: a
          })
        })
      }, nr = function (e) {
        var t, n = e.hotspot;
        return n.rewardScale ? (0, r.jsxs)("span", {
          className: "flex items-center",
          children: [(0, r.jsx)(tr, {
            width: 10,
            height: 12,
            fillColor: (0, ae.w)(null === n || void 0 === n ? void 0 : n.rewardScale)
          }), (0, r.jsx)("span", {
            className: "ml-1",
            children: null === n || void 0 === n || null === (t = n.rewardScale) || void 0 === t ? void 0 : t.toFixed(2)
          })]
        }) : null
      }, rr = function (e) {
        var t = e.hotspots, n = e.isLoading, s = void 0 === n || n, i = e.fetchMore, o = e.isLoadingMore, l = e.hasMore,
          c = e.count, u = e.showCount, d = void 0 !== u && u, f = (0, ee.Z)().selectHotspot,
          m = (0, a.useCallback)((function (e) {
            f(e.address)
          }), [f]), h = (0, a.useCallback)((function (e) {
            return e.address
          }), []), p = (0, a.useCallback)((function (e) {
            return "/hotspots/".concat(e.address)
          }), []), x = (0, a.useCallback)((function (e) {
            return (0, r.jsxs)(r.Fragment, {children: [!(0, ae.yV)(e) && (0, r.jsx)(Nn, {status: e.status}), bn()(e.address)]})
          }), []), v = (0, a.useCallback)((function (e) {
            return (0, r.jsxs)(r.Fragment, {
              children: [(0, r.jsx)(de, {
                geocode: e.geocode,
                shortenedLocationName: !0
              }), (0, r.jsx)(nr, {hotspot: e}), (0, r.jsx)(Bn, {hotspot: e}), (0, r.jsx)(En, {hotspot: e}), (0, r.jsx)(er, {hotspot: e})]
            })
          }), []), g = (0, a.useCallback)((function (e) {
            return (0, r.jsx)("span", {className: "whitespace-nowrap text-xs"})
          }), []);
        return (0, r.jsx)(In, {
          items: t,
          keyExtractor: h,
          listHeaderTitle: d ? "Hotspots" : null,
          listHeaderShowCount: d,
          listHeaderCount: c,
          linkExtractor: p,
          onSelectItem: m,
          isLoading: s,
          renderTitle: x,
          renderSubtitle: v,
          renderDetails: g,
          blankTitle: "No Hotspots",
          fetchMore: i,
          isLoadingMore: o,
          hasMore: l
        })
      }, ar = function () {
        var e = (0, vn.vy)(), t = e.hotspots, n = e.fetchMore, a = e.isLoadingInitial, s = e.isLoadingMore, i = e.hasMore;
        return (0, r.jsx)("div", {
          className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
            "overflow-y-scroll": !a,
            "overflow-y-hidden": a
          }), children: (0, r.jsx)(rr, {hotspots: t, isLoading: a, isLoadingMore: s, fetchMore: n, hasMore: i})
        })
      }, sr = function (e) {
        var t = e.className;
        return (0, r.jsx)("svg", {
          width: "24",
          height: "29",
          viewBox: "0 0 24 29",
          fill: "none",
          xmlns: "http://www.w3.org/2000/svg",
          className: t,
          children: (0, r.jsx)("path", {
            "fill-rule": "evenodd",
            "clip-rule": "evenodd",
            d: "M19.8001 8.96215L11.5582 0.720291L3.31638 8.96215L3.31714 8.96291C-1.06006 13.4608 -1.02272 20.6555 3.42916 25.1074C7.9187 29.5969 15.1977 29.5969 19.6872 25.1074C24.1391 20.6555 24.1764 13.4609 19.7993 8.96296L19.8001 8.96215ZM15.834 12.9051L11.5583 8.62938L7.28255 12.9051L7.28294 12.9055C5.01213 15.2389 5.0315 18.9714 7.34106 21.281C9.67015 23.6101 13.4464 23.6101 15.7755 21.281C18.085 18.9715 18.1044 15.239 15.8336 12.9055L15.834 12.9051Z",
            fill: "currentColor"
          })
        })
      }, ir = function () {
        var e = P().makers, t = (0, a.useCallback)((function (e) {
          return e.address
        }), []), n = (0, a.useCallback)((function (e) {
          return "/accounts/".concat(e.address)
        }), []), s = (0, a.useCallback)((function (e) {
          return (0, r.jsxs)("div", {
            className: "flex w-full", children: [(0, r.jsxs)("div", {
              className: "w-full",
              children: [(0, r.jsx)("div", {
                children: (0, r.jsx)("span", {
                  className: "text-black text-base font-semibold",
                  children: e.name
                })
              }), (0, r.jsxs)("div", {
                children: [(0, r.jsxs)("div", {
                  className: "my-1 flex items-center space-x-2 font-normal text-gray-600 text-sm",
                  children: [(0, r.jsxs)("span", {
                    className: "flex items-center space-x-1",
                    children: [(0, r.jsx)("img", {
                      alt: "",
                      src: "/images/dc.svg",
                      className: "w-3 h-3"
                    }), (0, r.jsx)("span", {className: "", children: e.dcBalance.toString(0)})]
                  }), (0, r.jsxs)("span", {
                    className: "text-xs",
                    children: ["(", e.assertsRemaining.toLocaleString(), " onboards remaining)"]
                  })]
                }), (0, r.jsxs)("div", {
                  className: "flex space-x-3 text-sm text-gray-600",
                  children: [(0, r.jsx)(fe.Z, {
                    title: "Hotspots added",
                    children: (0, r.jsxs)("div", {
                      className: "flex items-center space-x-1",
                      children: [(0, r.jsx)(pe, {className: "text-green-500 w-3 h-auto"}), (0, r.jsx)("span", {children: e.txns.addGatewayTxns.toLocaleString()})]
                    })
                  }), (0, r.jsx)(fe.Z, {
                    title: "Locations asserted",
                    children: (0, r.jsxs)("div", {
                      className: "flex items-center space-x-1",
                      children: [(0, r.jsx)(xe, {className: "text-pink-500 w-3 h-auto"}), (0, r.jsx)("span", {children: e.txns.assertLocationTxns.toLocaleString()})]
                    })
                  }), (0, r.jsx)(fe.Z, {
                    title: "HNT burned",
                    children: (0, r.jsxs)("div", {
                      className: "flex items-center space-x-1",
                      children: [(0, r.jsx)(sr, {className: "text-orange-300 w-3 h-auto"}), (0, r.jsx)("span", {children: e.burnedHNT.toString(2)})]
                    })
                  })]
                })]
              })]
            }), (0, r.jsx)("div", {
              className: "flex items-center",
              children: (0, r.jsx)("img", {alt: "", src: "/images/details-arrow.svg"})
            })]
          })
        }), []);
        return (0, r.jsx)("div", {
          className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
            "overflow-y-scroll": !!e,
            "overflow-y-hidden": !e
          }),
          children: (0, r.jsx)(In, {
            items: e,
            keyExtractor: t,
            linkExtractor: n,
            isLoading: !e,
            renderItem: s,
            render: !0
          })
        })
      };

    function or(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function lr(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function cr(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            lr(s, r, a, i, o, "next", e)
          }

          function o(e) {
            lr(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function ur(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function dr(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          ur(e, t, n[t])
        }))
      }
      return e
    }

    function fr(e) {
      return function (e) {
        if (Array.isArray(e)) return or(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return or(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return or(e, t)
      }(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var mr = function (e) {
      var t = e.geocode, n = e.showLocationName, a = void 0 === n || n, s = e.shortenedCountryName,
        i = void 0 !== s && s, o = ie()(t), l = (0, ae.S4)(o, i);
      return (0, r.jsxs)("span", {
        className: "flex flex-row items-center justify-start",
        children: [(0, r.jsx)(ue, {
          className: "mr-1",
          countryCode: null === t || void 0 === t ? void 0 : t.shortCountry
        }), a && l]
      })
    }, hr = function () {
      var e = function () {
          var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : 20,
            t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : "hotspotCount", n = (0, a.useState)(),
            r = n[0], s = n[1], i = (0, a.useState)([]), o = i[0], l = i[1], c = (0, a.useState)(!0), u = c[0], d = c[1],
            h = (0, a.useState)(!1), p = h[0], x = h[1], v = (0, a.useState)(!0), g = v[0], y = v[1];
          (0, Qt.r5)(cr(f().mark((function e() {
            var n;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  return e.next = 2, m.ZP.cities.list({order: t});
                case 2:
                  n = e.sent, s(n), d(!1);
                case 5:
                case"end":
                  return e.stop()
              }
            }), e)
          }))), []), (0, Qt.r5)(cr(f().mark((function t() {
            var n, a;
            return f().wrap((function (t) {
              for (; ;) switch (t.prev = t.next) {
                case 0:
                  if (r) {
                    t.next = 2;
                    break
                  }
                  return t.abrupt("return");
                case 2:
                  return x(!0), t.next = 5, r.take(e);
                case 5:
                  n = t.sent, a = n.map((function (e, t) {
                    return dr({}, e, {index: t})
                  })), l(a), x(!1), n.length < e && y(!1);
                case 10:
                case"end":
                  return t.stop()
              }
            }), t)
          }))), [r]);
          var j = (0, a.useCallback)(cr(f().mark((function t() {
            var n, a;
            return f().wrap((function (t) {
              for (; ;) switch (t.prev = t.next) {
                case 0:
                  return t.next = 2, r.take(e);
                case 2:
                  n = t.sent, a = n.map((function (e, t) {
                    return dr({}, e, {index: o.length + t})
                  })), l(fr(o).concat(fr(a)));
                case 5:
                case"end":
                  return t.stop()
              }
            }), t)
          }))), [r, e, o]);
          return {results: o, fetchMore: j, isLoadingInitial: u, isLoadingMore: p, hasMore: g}
        }(), t = e.results, n = e.fetchMore, s = e.isLoadingInitial, i = e.isLoadingMore, o = e.hasMore,
        l = (0, a.useCallback)((function (e) {
          return e.cityId
        }), []), c = (0, a.useCallback)((function (e) {
          return "/hotspots/cities/".concat(e.cityId)
        }), []), u = (0, a.useCallback)((function (e) {
          var t = (null === e || void 0 === e ? void 0 : e.longCity) ? e.longCity : e.longState;
          return (0, r.jsxs)("div", {
            className: "flex w-full", children: [(0, r.jsxs)("div", {
              className: "w-full",
              children: [(0, r.jsxs)("div", {
                className: "flex flex-row items-center justify-start",
                children: [(0, r.jsx)("span", {
                  className: "text-navy-400 font-bold text-base pr-1",
                  children: e.index + 1
                }), (0, r.jsx)("span", {className: "text-black text-base font-semibold", children: t})]
              }), (0, r.jsxs)("div", {
                children: [(0, r.jsx)("div", {
                  className: "my-1 flex items-center justify-start font-normal text-gray-600 text-sm",
                  children: (0, r.jsx)(mr, {
                    geocode: {
                      shortCountry: e.shortCountry,
                      longCity: e.longCity,
                      longCountry: e.longCountry,
                      longState: e.longState
                    }
                  })
                }), (0, r.jsxs)("div", {
                  className: "my-1 flex items-center justify-start space-x-2 font-normal text-gray-600 text-sm",
                  children: [(0, r.jsxs)("span", {
                    className: "flex items-center space-x-1",
                    children: [(0, r.jsx)(pe, {className: "text-green-500 w-3 h-auto"}), (0, r.jsxs)("span", {
                      className: "",
                      children: [e.hotspotCount.toLocaleString(), " hotspots deployed"]
                    })]
                  }), (0, r.jsxs)("span", {
                    className: "text-xs flex items-end",
                    children: ["(", (e.onlineCount / e.hotspotCount * 100).toLocaleString(void 0, {maximumFractionDigits: 2}), "% online)"]
                  })]
                })]
              })]
            }), (0, r.jsx)("div", {
              className: "flex items-center",
              children: (0, r.jsx)("img", {alt: "", src: "/images/details-arrow.svg"})
            })]
          })
        }), []);
      return (0, r.jsx)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !!t,
          "overflow-y-hidden": !t
        }),
        children: (0, r.jsx)(In, {
          items: t,
          keyExtractor: l,
          linkExtractor: c,
          isLoading: !t || s,
          renderItem: u,
          fetchMore: n,
          isLoadingMore: i,
          hasMore: o,
          render: !0
        })
      })
    }, pr = function () {
      return (0, r.jsx)(pt, {
        title: (0, r.jsx)(xn, {t: "hotspots.title"}),
        metaTitle: "Hotspots",
        children: (0, r.jsxs)(pn, {
          htmlTitleRoot: "Hotspots",
          children: [(0, r.jsx)(hn, {
            title: "Statistics",
            children: (0, r.jsx)(jn, {})
          }, "statistics"), (0, r.jsx)(hn, {
            title: "Latest Hotspots",
            path: "latest",
            children: (0, r.jsx)(ar, {})
          }, "latest"), (0, r.jsx)(hn, {
            title: "Makers",
            path: "makers",
            children: (0, r.jsx)(ir, {})
          }, "makers"), (0, r.jsx)(hn, {title: "Cities", path: "cities", children: (0, r.jsx)(hr, {})}, "latest")]
        })
      })
    }, xr = function (e) {
      var t = e.hotspot.rewardScale,
        n = t ? t.toLocaleString(void 0, {minimumFractionDigits: 2, maximumFractionDigits: 2}) : "N/A";
      return (0, r.jsx)(At, {
        title: "Transmit Scale",
        tooltip: (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)("div", {children: "Transmit scale is a multiplier that is applied to rewards of any Hotspots that witness you. The scale also affects how many rewards you receive as a Challengee."}), (0, r.jsx)("div", {
            style: {marginTop: "10px"},
            children: "Low Transmit scale does not mean your Hotspot earnings will be low. Make sure you have a great setup so you can witness Hotspots with 1.0 Transmit scales."
          })]
        }),
        value: n,
        icon: (0, r.jsx)(tr, {width: 21, height: 24, fillColor: t ? (0, ae.w)(t) : "#aaa"}),
        subtitle: (0, r.jsx)("span", {className: "text-gray-550", children: "No Change"})
      })
    }, vr = n(73858), gr = n(82646);

    function yr(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function jr(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function wr(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            jr(s, r, a, i, o, "next", e)
          }

          function o(e) {
            jr(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function br(e) {
      return function (e) {
        if (Array.isArray(e)) return yr(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return yr(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return yr(e, t)
      }(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    !function () {
      var e = wr(f().mark((function e() {
        var t, n, r = arguments;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return t = r.length > 0 && void 0 !== r[0] ? r[0] : 100, e.next = 3, m.ZP.blocks.list();
            case 3:
              return e.next = 5, e.sent.take(t);
            case 5:
              return n = e.sent, e.abrupt("return", JSON.parse(JSON.stringify(n)));
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })))
    }();
    var kr = function () {
      var e = wr(f().mark((function e() {
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.abrupt("return", m.ZP.blocks.getHeight());
            case 1:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function () {
        return e.apply(this, arguments)
      }
    }(), Nr = function (e) {
      var t = (0, Rt.ZP)("blockHeight", kr, {initialData: e, refreshInterval: 1e4}), n = t.data, r = t.error;
      return {height: n, isLoading: !r && !n, isError: r}
    }, Sr = function () {
      var e = wr(f().mark((function e(t) {
        var n;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.blocks.get(t);
            case 2:
              return n = e.sent, e.abrupt("return", n);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), Cr = (function () {
      var e = wr(f().mark((function e(t) {
        var n;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.block(t).transactions.list();
            case 2:
              return e.next = 4, e.sent.take(m.pA);
            case 4:
              return n = e.sent, e.abrupt("return", n);
            case 6:
            case"end":
              return e.stop()
          }
        }), e)
      })))
    }(), function (e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 50, n = (0, a.useState)(), r = n[0],
        s = n[1], i = (0, a.useState)([]), o = i[0], l = i[1], c = (0, a.useState)(!0), u = c[0], d = c[1],
        h = (0, a.useState)(!1), p = h[0], x = h[1], v = (0, a.useState)(!0), g = v[0], y = v[1];
      (0, Qt.r5)(wr(f().mark((function t() {
        var n;
        return f().wrap((function (t) {
          for (; ;) switch (t.prev = t.next) {
            case 0:
              return t.next = 2, m.ZP.block(e).transactions.list();
            case 2:
              n = t.sent, s(n), d(!1);
            case 5:
            case"end":
              return t.stop()
          }
        }), t)
      }))), []), (0, Qt.r5)(wr(f().mark((function e() {
        var n;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              if (r) {
                e.next = 2;
                break
              }
              return e.abrupt("return");
            case 2:
              return x(!0), e.next = 5, r.take(t);
            case 5:
              n = e.sent, l((0, gr.Pl)(n)), x(!1), n.length < t && y(!1);
            case 9:
            case"end":
              return e.stop()
          }
        }), e)
      }))), [r]);
      var j = (0, a.useCallback)(wr(f().mark((function e() {
        var n;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, r.take(t);
            case 2:
              n = e.sent, l(br(o).concat(br((0, gr.Pl)(n))));
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      }))), [r, t, o]);
      return {results: o, fetchMore: j, isLoadingInitial: u, isLoadingMore: p, hasMore: g}
    }), Lr = function () {
      var e = wr(f().mark((function e(t) {
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.abrupt("return", m.ZP.blocks.getHeight({maxTime: t}));
            case 1:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }();

    function Tr(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Pr = function () {
      var e = (0, a.useState)("hotspot"), t = e[0], n = e[1], r = (0, a.useState)(!0), s = r[0], i = r[1];
      return (0, a.useEffect)((function () {
        var e = function () {
          var e, t = (e = f().mark((function e() {
            var t, r;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  return i(!0), e.next = 3, m.ZP.vars.get(["poc_challenger_type"]);
                case 3:
                  t = e.sent, void 0 !== (r = t.pocChallengerType) && n(r), i(!1);
                case 7:
                case"end":
                  return e.stop()
              }
            }), e)
          })), function () {
            var t = this, n = arguments;
            return new Promise((function (r, a) {
              var s = e.apply(t, n);

              function i(e) {
                Tr(s, r, a, i, o, "next", e)
              }

              function o(e) {
                Tr(s, r, a, i, o, "throw", e)
              }

              i(void 0)
            }))
          });
          return function () {
            return t.apply(this, arguments)
          }
        }();
        e()
      }), []), {challengeIssuer: t, challengeIssuerLoading: s}
    };

    function Ar(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Mr = function (e) {
      var t, n, s, i, o = e.hotspot,
        l = null === o || void 0 === o || null === (t = o.status) || void 0 === t ? void 0 : t.online, c = Pr(),
        u = c.challengeIssuer, d = c.challengeIssuerLoading, m = (0, a.useMemo)((function () {
          return "validator" === u
        }), [u, d]), h = (0, Qt.r5)((i = f().mark((function e() {
          var t, n, r;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                if (n = null === o || void 0 === o || null === (t = o.status) || void 0 === t ? void 0 : t.timestamp) {
                  e.next = 4;
                  break
                }
                return e.abrupt("return", 1);
              case 4:
                return e.next = 6, Lr(n);
              case 6:
                return r = e.sent, e.abrupt("return", r);
              case 8:
              case"end":
                return e.stop()
            }
          }), e)
        })), function () {
          var e = this, t = arguments;
          return new Promise((function (n, r) {
            var a = i.apply(e, t);

            function s(e) {
              Ar(a, n, r, s, o, "next", e)
            }

            function o(e) {
              Ar(a, n, r, s, o, "throw", e)
            }

            s(void 0)
          }))
        }), [o.status.timestamp]), p = h.result, x = h.loading, v = (0, a.useMemo)((function () {
          var e;
          return "offline" === l ? "Offline" : m ? "Connected" : !(null === o || void 0 === o || null === (e = o.status) || void 0 === e ? void 0 : e.height) || !p || p - o.status.height >= ae.ei ? "Syncing" : "Synced"
        }), [o.status.height, l, p, m]);
      return (0, r.jsx)(At, {
        title: "Sync Status",
        value: v,
        subtitle: (null === o || void 0 === o || null === (n = o.status) || void 0 === n ? void 0 : n.timestamp) && (0, r.jsxs)("span", {
          className: "text-gray-550 text-sm font-sans",
          children: ["Last Updated ", (0, r.jsx)(vr.Z, {date: null === o || void 0 === o || null === (s = o.status) || void 0 === s ? void 0 : s.timestamp})]
        }),
        isLoading: x || d,
        tooltip: "Hotspots gossip their sync status over the p2p network. Pair with a hotspot over Bluetooth to get the most up-to-date sync status.",
        icon: (0, r.jsx)("div", {
          className: ce()("rounded-full w-5 h-5", {
            "bg-green-400": "online" === l,
            "bg-red-400": "offline" === l
          })
        })
      })
    }, _r = (0, a.memo)(Mr);

    function Or(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function Hr(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function Ir(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            Hr(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Hr(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function Br(e) {
      return function (e) {
        if (Array.isArray(e)) return Or(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return Or(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return Or(e, t)
      }(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    !function () {
      var e = Ir(f().mark((function e(t) {
        var n;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.transactions.get(t);
            case 2:
              return n = e.sent, e.abrupt("return", JSON.parse(JSON.stringify(n)));
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })))
    }();
    var Er = function () {
      var e = Ir(f().mark((function e(t, n, r) {
        var a, s;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.hotspot(t).challenges.sum.list({
                minTime: "-".concat(n, " ").concat(r),
                maxTime: new Date,
                bucket: r
              });
            case 2:
              return a = e.sent, e.next = 5, a.take(m.pA);
            case 5:
              return s = e.sent, e.abrupt("return", s.reverse());
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t, n, r) {
        return e.apply(this, arguments)
      }
    }(), Fr = function (e) {
      var t, n = e.value, a = e.precision, s = void 0 === a ? 3 : a, i = 1e9, o = 1e6;
      return t = n >= i ? [(0, c.round)(n / i, s), "B"].join("") : n >= o ? [(0, c.round)(n / o, s), "M"].join("") : n >= 1e3 ? [(0, c.round)(n / 1e3, s), "K"].join("") : (0, c.round)(n, s).toLocaleString(), (0, r.jsx)("span", {children: t})
    }, Dr = n(53328), Zr = n(55376), Rr = n(58545), Gr = n(87344);

    function Vr(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function Wr(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          Vr(e, t, n[t])
        }))
      }
      return e
    }

    Dr.kL.register(Dr.uw, Dr.f$, Dr.ZL, Dr.Dx, Dr.u, Dr.De);
    var Ur = {
      layout: {autoPadding: !1},
      hover: {intersect: !1},
      backdropPadding: 0,
      padding: 0,
      plugins: {
        legend: {display: !1},
        tooltip: {
          caretPadding: 10,
          caretX: 0,
          caretY: 0,
          intersect: !1,
          mode: "index",
          yAlign: "center",
          position: "nearest",
          callbacks: {
            label: function (e) {
              var t = e.dataset.label, n = e.raw;
              if ("N/A" === n) return "".concat(t, ": ").concat(n);
              var r = S.Balance.fromFloat(n, S.CurrencyType.networkToken);
              return "".concat(t, ": ").concat(r.toString(3))
            }
          },
          displayColors: !1,
          padding: 3,
          pointHitRadius: 5,
          pointRadius: 1,
          caretSize: 10,
          backgroundColor: "rgba(255,255,255,.9)",
          borderWidth: 1,
          bodyFont: {family: "Inter", size: 12},
          bodyColor: "#303030",
          titleFont: {family: "Inter"},
          titleColor: "rgba(0,0,0,0.6)"
        }
      },
      scales: {
        y: {
          ticks: {display: !1},
          grid: {drawBorder: !1, borderWidth: 0, drawTicks: !1, color: "transparent", width: 0, backdropPadding: 0},
          drawBorder: !1,
          drawTicks: !1
        }, x: {ticks: {display: !1}, grid: {drawBorder: !1, borderWidth: 0, drawTicks: !1, display: !1}}
      },
      responsive: !0,
      maintainAspectRatio: !1
    }, zr = function (e) {
      var t = e.title, n = e.periodSelector, s = e.series, i = void 0 === s ? [] : s, o = e.isLoading, l = e.showTarget,
        u = void 0 !== l && l, d = e.targetSeries, f = void 0 === d ? [] : d, m = e.dataPointTimePeriod,
        h = void 0 === m ? "day" : m, p = e.periodLabel, x = e.periodLength, v = void 0 === x ? 30 : x, g = zt().market,
        y = v, j = (0, a.useMemo)((function () {
          return i.length <= y ? [0, (0, c.sumBy)(i, "total")] : (0, c.chunk)(i, y).map((function (e) {
            return (0, c.sumBy)(e, "total")
          }))
        }), [y, i]), w = j[0], b = j[1], k = (0, a.useMemo)((function () {
          return (b - w) / w
        }), [w, b]), N = (0, a.useMemo)((function () {
          return (0, c.takeRight)(i, y)
        }), [y, i]), S = (0, a.useMemo)((function () {
          return N.map((function (e) {
            return {label: e.timestamp, value: e.total}
          }))
        }), [N]), C = (0, a.useMemo)((function () {
          return u ? N.map((function (e) {
            var t = f.find((function (t) {
              return (null === t || void 0 === t ? void 0 : t.date) === e.timestamp.slice(0, 10)
            }));
            return t ? {label: t.date, value: t.avg_rewards} : null
          })) : null
        }), [N, u, f]), L = (0, a.useRef)(null), T = (0, a.useState)(271), P = T[0], A = T[1];
      (0, a.useEffect)((function () {
        (null === L || void 0 === L ? void 0 : L.current) && A(L.current.offsetWidth)
      }), [L]);
      var M = (0, a.useMemo)((function () {
        var e = P / (2 * N.length);
        return {
          labels: N.map((function (e) {
            var t = new Date(e.timestamp), n = t.getTimezoneOffset(), r = (0, Rr.Z)(t, n);
            return "day" === h ? (0, Gr.Z)(r, "MMM d") : "".concat((0, Gr.Z)(r, "MMM d HH:mm"), " UTC")
          })), datasets: [{
            label: "Your Earnings",
            data: S.map((function (e) {
              return null !== (null === e || void 0 === e ? void 0 : e.value) ? e.value : null
            })),
            backgroundColor: "#464eff",
            minBarLength: e,
            barThickness: .75 * e,
            borderRadius: .75 * e * 2,
            borderSkipped: !1
          }, Wr({}, u && {
            label: "Network Average",
            data: C.map((function (e) {
              return (null === e || void 0 === e ? void 0 : e.value) || "N/A"
            })),
            backgroundColor: "#c7c8e9",
            minBarLength: e,
            barThickness: .75 * e,
            borderRadius: .75 * e * 2,
            borderSkipped: !1
          })]
        }
      }), [S, C, P, h, N, u]);
      return (0, r.jsxs)("div", {
        className: "bg-gray-200 p-3 rounded-lg flex flex-col col-span-2", children: [(0, r.jsxs)("div", {
          className: ce()("flex", {"h-28": !n, "h-24": n}),
          children: [(0, r.jsxs)("div", {
            className: "w-1/3 relative",
            children: [(0, r.jsx)("div", {
              className: "text-gray-600 absolute text-sm whitespace-nowrap",
              children: t
            }), (0, r.jsx)("div", {
              className: "text-3xl font-medium mt-1.5 tracking-tight pt-4",
              children: o ? (0, r.jsx)(me, {}) : (0, r.jsx)(Fr, {value: b})
            }), (0, r.jsx)("div", {
              className: "text-base text-gray-600 mb-1 tracking-tight w-full break-all",
              children: o || !g ? (0, r.jsx)(me, {className: "w-1/3 my-2"}) : (0, r.jsx)(Zt, {
                value: b * (null === g || void 0 === g ? void 0 : g.price),
                isLarge: !0
              })
            }), w > 0 && (0, r.jsxs)("div", {
              className: ce()("text-sm font-medium", {
                "text-green-500": k > 0,
                "text-navy-400": k < 0
              }), children: [k > 0 ? "+" : "", k.toLocaleString(void 0, {style: "percent", maximumFractionDigits: 3})]
            })]
          }), (0, r.jsxs)("div", {
            className: "p-4 pr-0 relative w-[99%]",
            children: [(0, r.jsx)("div", {
              className: "max-w-full h-full",
              ref: L,
              children: (0, r.jsx)(Zr.$Q, {
                options: Ur,
                data: M,
                style: {maxWidth: P || 271, width: "100%", height: "100%"}
              })
            }), p && (0, r.jsx)("div", {
              className: "absolute right-4 bottom-0 text-gray-550 text-xs z-10",
              children: p
            })]
          })]
        }), n]
      })
    }, Kr = function (e) {
      var t = e.periods, n = e.handlePeriodChange, s = (0, a.useState)(0), i = s[0], o = s[1];
      return (0, r.jsx)("div", {
        className: "flex items-center px-1 space-x-3 lg:space-x-2 justify-end",
        children: t.map((function (e, t) {
          return (0, r.jsxs)("button", {
            className: ce()("focus:outline-none font-medium text-sm border-solid border border-transparent font-sans focus:border-navy-400 focus:border-opacity-50 bg-gray-300 px-2 rounded-md", {
              "text-navy-400": i === t,
              "text-black": i !== t
            }), onClick: function () {
              o(t), n(e.number, e.type)
            }, children: [e.number, e.type.slice(0, 1).toUpperCase()]
          }, "".concat(t, "-").concat(e.type))
        }))
      })
    }, qr = function (e) {
      var t = e.title, n = e.type, s = e.address, i = e.periods,
        o = void 0 === i ? [{number: 24, type: "hour"}, {number: 7, type: "day"}, {
          number: 14,
          type: "day"
        }, {number: 30, type: "day"}] : i, l = (0, a.useState)(o[0].number), c = l[0], u = l[1],
        d = (0, a.useState)(o[0].type), f = d[0], m = d[1], h = Xn(s, n, 2 * c, f, "day" === f), p = h.rewards,
        x = h.isLoading, v = (0, a.useCallback)((function (e, t) {
          u(e), m(t)
        }), []), g = (0, L.ZP)("/network/rewards/averages").data;
      return (0, r.jsx)(zr, {
        title: t,
        isLoading: x,
        periodLength: c,
        periodSelector: (0, r.jsx)(Kr, {periods: o, handlePeriodChange: v}),
        series: p,
        targetSeries: g,
        showTarget: "hotspot" === n && "day" === f,
        dataPointTimePeriod: f,
        periodLabel: !0
      })
    }, $r = function (e) {
      var t = e.isVisible, n = void 0 === t || t, a = e.warningText, s = e.subtitle, i = e.link, o = e.linkText;
      if (!n) return null;
      var l = (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsxs)("span", {
          className: "flex items-center justify-start",
          children: [(0, r.jsx)("img", {
            alt: "",
            className: "h-3 mr-1",
            src: "/images/warning.svg"
          }), (0, r.jsx)("div", {
            className: "text-yellow-700 text-xs font-semibold whitespace-nowrap truncate",
            children: a
          })]
        }), s && (0, r.jsx)("div", {className: "text-xs text-gray-600 mt-1", children: s})]
      });
      return i && o ? (0, r.jsxs)("a", {
        className: "bg-gray-200 hover:bg-gray-300 p-3 rounded-lg col-span-2 cursor-pointer flex items-center justify-between space-x-2",
        target: "_blank",
        rel: "noopener noreferrer",
        href: i,
        children: [l, (0, r.jsxs)("span", {
          className: "text-gray-600 font-sans text-right whitespace-nowrap text-xs",
          children: [o, " ", "->"]
        })]
      }) : (0, r.jsx)("div", {
        className: "bg-gray-200 p-3 rounded-lg col-span-2 flex items-center justify-between space-x-2",
        children: l
      })
    }, Jr = {
      state_channel_open_v1: {color: "#22CAAC", name: "State Channel Open"},
      price_oracle_v1: {color: "#292929", name: "Price Oracle"},
      state_channel_close_v1: {
        color: "#22CAAC",
        hotspotContextName: "Transferred Packets",
        name: "State Channel Close"
      },
      payment_v1: {color: "#1D91F8", name: "Payment"},
      payment_v2: {color: "#1D91F8", name: "Payment"},
      poc_request_v1: {
        color: "#A667F6",
        name: "PoC Challenge",
        hotspotContextName: "Constructed Challenge",
        tooltip: "Proof of Coverage Challenge"
      },
      poc_receipts_v1: {color: "#1D91F8", name: "PoC Receipt", tooltip: "Proof of Coverage Receipt"},
      poc_receipts_v2: {color: "#1D91F8", name: "PoC Receipt", tooltip: "Proof of Coverage Receipt"},
      rewards_v1: {
        color: "#A667F6",
        name: "Mining Reward",
        accountContextName: "Received Mining Rewards",
        hotspotContextName: "Received Mining Rewards",
        validatorContextName: "Received Mining Rewards",
        tooltip: "Mining Reward (v1)"
      },
      rewards_v2: {
        color: "#A667F6",
        name: "Mining Reward",
        accountContextName: "Received Mining Rewards",
        hotspotContextName: "Received Mining Rewards",
        validatorContextName: "Received Mining Rewards",
        tooltip: "Mining Reward (v2)"
      },
      rewards_v3: {
        color: "#A667F6",
        name: "Mining Reward",
        accountContextName: "Received Mining Rewards",
        hotspotContextName: "Received Mining Rewards",
        validatorContextName: "Received Mining Rewards",
        tooltip: "Mining Reward (v3)"
      },
      consensus_group_v1: {
        color: "#FF6666",
        name: "Consensus Election",
        hotspotContextName: "Participated in Consensus",
        tooltip: "Consensus Election"
      },
      transfer_hotspot_v1: {
        color: "#D3293D",
        name: "Transfer Hotspot",
        tooltip: "Hotspot Transfer Confirmation Transaction"
      },
      transfer_hotspot_v2: {
        color: "#D3293D",
        name: "Transfer Hotspot",
        tooltip: "Hotspot Transfer Confirmation Transaction"
      },
      poc_challengers: {
        color: "#A667F6",
        name: "Challenger",
        hotspotContextName: "Challenged Beaconer",
        tooltip: "PoC challenger"
      },
      poc_challengees: {
        color: "#1D91F8",
        name: "Beacon",
        hotspotContextName: "Broadcast Beacon",
        tooltip: "PoC challengee"
      },
      assert_location_v1: {
        color: "#93D30B",
        name: "Assert Location",
        hotspotContextName: "Asserted Location",
        tooltip: "Assert Location Transaction (v1)"
      },
      assert_location_v2: {
        color: "#93D30B",
        name: "Assert Location",
        hotspotContextName: "Asserted Location",
        tooltip: "Assert Location Transaction (v2)"
      },
      add_gateway_v1: {
        color: "#29D391",
        name: "Add Hotspot",
        hotspotContextName: "Added to Blockchain",
        tooltip: "Add Gateway Transaction"
      },
      poc_witnesses: {
        color: "#FCC945",
        name: "Witness",
        hotspotContextName: "Witnessed Beacon",
        tooltip: "PoC witness"
      },
      poc_witnesses_valid: {
        color: "#FCC945",
        name: "Witness",
        hotspotContextName: "Witnessed Beacon",
        tooltip: "PoC witness (Valid)"
      },
      poc_witnesses_invalid: {
        color: "#617095",
        name: "Witness",
        hotspotContextName: "Witnessed Beacon (Invalid)",
        tooltip: "PoC witness (Invalid)"
      },
      securities: {
        color: "#9AE8C9",
        name: "Security Token Reward",
        tooltip: "Mining Reward for Security Token holders"
      },
      stake_validator_v1: {
        color: "#7830D3",
        name: "Stake Validator",
        accountContextName: "Staked Validator",
        validatorContextName: "Received Stake"
      },
      unstake_validator_v1: {
        color: "#FF6666",
        name: "Unstake Validator",
        accountContextName: "Unstaked Validator",
        validatorContextName: "Unstaked"
      },
      transfer_validator_stake_v1: {
        color: "#A667F6",
        name: "Transfer Stake",
        accountContextName: "Stake Transferred",
        validatorContextName: "Stake Transferred"
      },
      receive_transferred_stake: {
        color: "#A667F6",
        name: "Receive Transfer Stake",
        accountContextName: "Received Transferred Stake",
        validatorContextName: "Received Transferred Stake"
      },
      send_transferred_stake: {
        color: "#A667F6",
        name: "Send Transfer Stake",
        accountContextName: "Transferred Stake",
        validatorContextName: "Sent Transferred Stake"
      },
      validator_heartbeat_v1: {
        color: "#A667F6",
        name: "Validator Heartbeat",
        validatorContextName: "Produced Heartbeat"
      },
      token_burn_v1: {color: "#F49F3B", name: "Token Burn"},
      default: {color: "#474DFF"}
    }, Yr = function (e) {
      var t, n, r, a, s, i, o, l = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : "block";
      return "hotspot" === l ? (null === (t = Jr[e]) || void 0 === t ? void 0 : t.hotspotContextName) || (null === (n = Jr[e]) || void 0 === n ? void 0 : n.name) || e : "account" === l ? (null === (r = Jr[e]) || void 0 === r ? void 0 : r.accountContextName) || (null === (a = Jr[e]) || void 0 === a ? void 0 : a.name) || e : "validator" === l ? (null === (s = Jr[e]) || void 0 === s ? void 0 : s.validatorContextName) || (null === (i = Jr[e]) || void 0 === i ? void 0 : i.name) || e : (null === (o = Jr[e]) || void 0 === o ? void 0 : o.name) || e
    }, Xr = function (e) {
      return (Jr[e] || Jr.default).color
    }, Qr = function (e) {
      return "".concat(e.slice(0, 5), "...").concat(e.slice(-5))
    }, ea = function (e) {
      return "challenger" === e ? "poc_challengers" : "challengee" === e ? "poc_challengees" : "witness" === e ? "poc_witnesses_valid" : "poc_receipts_v1"
    }, ta = function (e, t) {
      return e.challenger === t ? "poc_challengers" : e.path.some((function (e) {
        return e.challengee === t
      })) ? "poc_challengees" : e.path.some((function (e) {
        return e.witnesses.some((function (e) {
          return e.gateway === t && e.isValid
        }))
      })) ? "poc_witnesses_valid" : "poc_witnesses_invalid"
    }, na = function (e) {
      switch (e) {
        case"witness_too_close":
          return "Witness too close";
        case"witness_rssi_too_high":
          return "Witness RSSI too high";
        case"witness_on_incorrect_channel":
          return "Witness on incorrect channel";
        case"witness_rssi_below_lower_bound":
          return "Witness RSSI below lower bound";
        default:
          return "".concat(e)
      }
    }, ra = n(4314), aa = function (e) {
      var t = e.time, n = e.addSuffix, a = void 0 === n || n;
      return (0, r.jsx)("span", {children: (0, ra.Z)(new Date(1e3 * t), {addSuffix: a})})
    };

    function sa(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var ia = function (e) {
      var t, n = e.context, s = e.address, i = (0, a.useState)([]), c = i[0], u = i[1], d = (0, a.useState)(!0),
        h = d[0], p = d[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return p(!0), e.t0 = u, e.next = 4, m.ZP.hotspot(s).roles.list();
            case 4:
              return e.next = 6, e.sent.take(5);
            case 6:
              e.t1 = e.sent, (0, e.t0)(e.t1), p(!1);
            case 9:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            sa(s, r, a, i, o, "next", e)
          }

          function o(e) {
            sa(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), [s]), (0, r.jsxs)(o.Link, {
        className: "bg-gray-200 hover:bg-gray-300 p-3 rounded-lg col-span-2 flex items-center justify-between w-full",
        to: "/".concat(n, "s/").concat(s, "/activity"),
        children: [(0, r.jsxs)("div", {
          className: "w-full",
          children: [(0, r.jsx)("div", {
            className: "text-gray-600 text-sm whitespace-nowrap",
            children: "Recent Activity"
          }), (0, r.jsx)("div", {
            className: "my-1.5 flex items-center justify-start flex-col w-full",
            children: h ? (0, r.jsxs)("div", {
              className: "space-y-2 flex flex-col items-center justify-start w-full",
              children: [(0, r.jsx)(me, {
                className: "w-full h-3.5",
                defaultSize: !1
              }), (0, r.jsx)(me, {
                className: "w-full h-3.5",
                defaultSize: !1
              }), (0, r.jsx)(me, {
                className: "w-full h-3.5",
                defaultSize: !1
              }), (0, r.jsx)(me, {
                className: "w-full h-3.5",
                defaultSize: !1
              }), (0, r.jsx)(me, {className: "w-full h-3.5", defaultSize: !1})]
            }) : c.map((function (e) {
              return (0, r.jsxs)("div", {
                className: "flex items-center justify-between w-full",
                children: [(0, r.jsx)("div", {
                  className: "min-w-[4px] h-[10px] rounded-sm",
                  style: {backgroundColor: e.type.startsWith("poc_receipts") ? Xr(ea(e.role)) : Xr(e.type)}
                }), (0, r.jsx)("div", {
                  className: "text-xs md:text-sm text-black tracking-tight w-full break-all ml-1",
                  children: e.type.startsWith("poc_receipts") ? Yr(ea(e.role), "hotspot") : Yr(e.type, "hotspot")
                }), (0, r.jsx)("div", {
                  className: "text-xs md:text-sm text-gray-600 tracking-tight w-full break-all text-right pr-5",
                  children: (0, r.jsx)(aa, {time: e.time})
                })]
              })
            }))
          })]
        }), (0, r.jsx)("div", {
          className: "flex",
          children: (0, r.jsx)(l.default, {src: "/images/details-arrow.svg", width: 14, height: 14})
        })]
      })
    }, oa = (0, a.memo)(ia), la = function (e) {
      var t, n, s = e.hotspot, i = e.isDataOnly, o = e.liteHotspotsActive, l = function (e) {
          var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 30,
            n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : "day",
            r = "beacons/hotspots/".concat(e, "/").concat(t, "/").concat(n), a = function (e, t, n) {
              return function () {
                return Er(e, t, n)
              }
            }, s = (0, Rt.ZP)(r, a(e, t, n), {refreshInterval: 6e5}), i = s.data, o = s.error;
          return {beaconSums: i, isLoading: !o && !i, isError: o}
        }(s.address, 2, "week"), c = l.beaconSums, u = l.isLoading, d = (0, Se.Z)(), f = d.selectedTxn,
        m = d.clearSelectedTxn, h = (0, ee.Z)().clearSelectedHotspot;
      (0, a.useEffect)((function () {
        return f && m(), function () {
          m(), h()
        }
      }), [f, m, h]), (0, a.useEffect)((function () {
        return function () {
          m()
        }
      }), [m]);
      var p = (null === s || void 0 === s || null === (t = s.errors) || void 0 === t ? void 0 : t.length) > 0;
      return (0, r.jsxs)(r.Fragment, {
        children: [i && (0, r.jsx)(Pn, {
          title: "Data-Only Hotspot",
          description: (0, r.jsxs)("div", {
            className: "space-y-2.5",
            children: [(0, r.jsx)("div", {children: "This Hotspot transfers data packets only and does not participate in Beacons, Witnessing, and Proof-of-Coverage."}), (0, r.jsx)("div", {children: "It does not contribute to transmit scaling."}), (0, r.jsx)("div", {
              children: (0, r.jsxs)("a", {
                className: "text-navy-400 hover:text-navy-300 flex items-center",
                href: "https://docs.helium.com/mine-hnt/data-only-hotspots",
                rel: "noopener noreferrer",
                target: "_blank",
                children: ["Learn more", (0, r.jsx)(Pt, {className: "h-3.5 ml-1"})]
              })
            })]
          })
        }), (0, r.jsxs)(Dt, {
          children: [!i && (0, r.jsxs)(r.Fragment, {
            children: [!o && (0, r.jsx)($r, {
              isVisible: (0, ae.HW)(s.status.listenAddrs),
              warningText: "Hotspot is relayed. Expect lower earnings.",
              link: "https://docs.helium.com/troubleshooting/network-troubleshooting",
              linkText: "Fix it"
            }), (0, r.jsx)(xr, {hotspot: s}), (0, r.jsx)(_r, {hotspot: s}), (0, r.jsx)($r, {
              isVisible: s.rewardScale && s.rewardScale < 1,
              warningText: "Suboptimal Transmit Scale",
              link: "https://app.hotspotty.net/hotspots/".concat(s.address, "/reward-scaling"),
              linkText: "Improve"
            })]
          }), (0, r.jsx)(qr, {
            address: null === s || void 0 === s ? void 0 : s.address,
            title: "Earnings (UTC)",
            type: "hotspot"
          }), (0, r.jsx)(oa, {
            context: "hotspot",
            address: s.address
          }), !i && (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsx)(_t, {
              title: "7D Avg Beacons",
              linkTo: "/hotspots/".concat(null === s || void 0 === s ? void 0 : s.address, "/activity"),
              series: c,
              isLoading: u,
              dataKey: "sum",
              changeType: "percent"
            }), (0, r.jsx)(At, {
              title: "Total Witnessed",
              linkTo: "/hotspots/".concat(null === s || void 0 === s ? void 0 : s.address, "/witnessed"),
              value: p ? "Error fetching" : null === s || void 0 === s || null === (n = s.witnessed) || void 0 === n ? void 0 : n.length,
              valueIsText: p,
              subtitle: (0, r.jsx)("span", {
                className: "text-gray-550 text-sm font-sans",
                children: "Within past 5 days"
              })
            })]
          })]
        })]
      })
    };

    function ca(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function ua(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function da(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            ua(s, r, a, i, o, "next", e)
          }

          function o(e) {
            ua(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function fa(e) {
      return function (e) {
        if (Array.isArray(e)) return ca(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return ca(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return ca(e, t)
      }(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var ma = function (e, t) {
      return {hotspot: m.ZP.hotspot(e), account: m.ZP.account(e), validator: m.ZP.validator(e)}[t]
    }, ha = function (e) {
      var t = e.highlightColor, n = function (e) {
        var t = e.role, n = "/images/activity-icons";
        switch (e.type) {
          case"rewards_v1":
          case"rewards_v2":
          case"rewards_v3":
            return "".concat(n, "/received_rewards.svg");
          case"payment_v1":
          case"payment_v2":
            return "".concat(n, "payee" === t ? "/payment_received.svg" : "payer" === t ? "/payment_sent.svg" : "/payment.svg");
          case"assert_location_v1":
          case"assert_location_v2":
            return "".concat(n, "/assert_location.svg");
          case"add_gateway_v1":
            return "".concat(n, "/add_hotspot.svg");
          case"poc_request_v1":
            return "".concat(n, "/poc_challenger.svg");
          case"poc_receipts_v1":
          case"poc_receipts_v2":
            return "".concat(n, "witness" === t ? "/poc_witness.svg" : "challengee" === t ? "/poc_challengee.svg" : "challenger" === t ? "/poc_challenger.svg" : "/poc_receipts.svg");
          case"token_burn_v1":
            return "".concat(n, "/token_burn.svg");
          case"stake_validator_v1":
            return "".concat(n, "/staked_validator.svg");
          case"unstake_validator_v1":
            return "".concat(n, "/unstake_validator.svg");
          case"transfer_validator_stake_v1":
            return "".concat(n, "/transferred_stake.svg");
          case"validator_heartbeat_v1":
            return "".concat(n, "/validator_heartbeat.svg");
          case"state_channel_open_v1":
            return "".concat(n, "/state_channel_open.svg");
          case"state_channel_close_v1":
            return "".concat(n, "/state_channel_close.svg");
          case"transfer_hotspot_v1":
          case"transfer_hotspot_v2":
            return "".concat(n, "/transfer_hotspot.svg");
          default:
            return null
        }
      }(e.txn);
      return (0, r.jsx)("div", {
        children: n ? (0, r.jsx)("img", {
          src: n,
          className: "w-9 h-9",
          alt: ""
        }) : (0, r.jsx)("div", {className: "w-9 h-9 rounded-full", style: {backgroundColor: t}})
      })
    }, pa = function (e) {
      var t = e.txn, n = e.expanded;
      return (0, r.jsxs)("span", {
        className: "flex flex-auto whitespace-nowrap items-center space-x-1 px-4",
        children: [(0, r.jsx)("img", {
          alt: "",
          src: "/images/clock-outline.svg",
          className: "w-3 h-3"
        }), n ? (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)("span", {
            className: "hidden md:block text-xs text-gray-600 font-sans font-extralight ml-1 mt-px md:mt-0.5",
            children: (0, r.jsx)(re(), {date: t.time})
          }), (0, r.jsx)("span", {
            className: "block md:hidden text-xs text-gray-600 font-sans font-extralight ml-1 mt-px md:mt-0.5",
            children: (0, r.jsx)(vr.Z, {date: 1e3 * t.time, timeStyle: "mini"})
          })]
        }) : (0, r.jsx)("span", {
          className: "text-xs text-gray-600 font-sans font-extralight ml-1 mt-px md:mt-0.5",
          children: (0, r.jsx)(vr.Z, {date: 1e3 * t.time, timeStyle: "mini"})
        })]
      })
    }, xa = function (e) {
      var t = e.className;
      return (0, r.jsx)("svg", {
        className: t,
        width: "16",
        height: "9",
        viewBox: "0 0 16 9",
        fill: "none",
        xmlns: "http://www.w3.org/2000/svg",
        children: (0, r.jsx)("path", {
          d: "M14.998 7.99438L7.99805 0.994385L0.998047 7.99438",
          stroke: "#9D9DC0",
          strokeLinecap: "round",
          strokeLinejoin: "round"
        })
      })
    }, va = n(56203), ga = function (e, t) {
      return (0, va.Z)((0, Fn.xm)(e), (0, Fn.xm)(t), {units: "meters"})
    }, ya = function (e) {
      return 0 === e ? "Same hex" : e < 1e3 ? "~".concat(10 * Math.round(e / 10), " m") : "~".concat((e / 1e3).toLocaleString(void 0, e < 1e4 ? {maximumFractionDigits: 1} : {maximumFractionDigits: 0}), " km")
    };

    function ja(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function wa(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return ja(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return ja(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var ba = function (e) {
      var t = e.path, n = t.witnesses, a = void 0 === n ? [] : n, s = t.challengeeLocationHex,
        i = (0, ee.Z)().selectHotspot;
      return (0, r.jsxs)("div", {
        className: "bg-gray-200 p-3 rounded-lg col-span-2",
        children: [(0, r.jsxs)("div", {
          className: "text-gray-600 text-sm leading-loose",
          children: [(0, r.jsxs)("span", {
            className: ce()("flex items-center justify-start", {"mb-3": a.length > 0}),
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/witness-yellow-mini.svg",
              className: "h-4 w-auto mr-1"
            }), a.length, " Witnesses"]
          }), 0 === a.length && (0, r.jsx)("span", {
            className: "text-2xl font-medium text-black my-1.5 tracking-tight w-full break-all",
            children: "No witnesses"
          })]
        }), (0, r.jsx)("div", {
          className: "space-y-2", children: a.map((function (e) {
            var t, n, a = wa((0, H.h3ToGeo)(e.locationHex), 2), l = a[0], c = a[1], u = wa((0, H.h3ToGeo)(s), 2),
              d = u[0], f = u[1];
            return (0, r.jsxs)("div", {
              className: "flex justify-between items-start pb-4", children: [(0, r.jsxs)("div", {
                children: [(0, r.jsx)(o.Link, {
                  to: "/hotspots/".concat(e.gateway),
                  onClick: function () {
                    return i(e.gateway)
                  },
                  className: "text-base leading-tight tracking-tight text-navy-1000 hover:text-navy-400 transition-all duration-150 flex items-center pb-2",
                  children: bn()(e.gateway)
                }), (0, r.jsx)("div", {
                  className: "flex items-center text-sm leading-tight tracking-tighter text-gray-600 space-x-1.5",
                  children: (0, r.jsxs)("div", {
                    className: "grid grid-cols-2 gap-y-1 gap-x-2",
                    children: [(0, r.jsx)("span", {children: "Distance"}), (0, r.jsx)(fe.Z, {
                      title: (0, r.jsx)(xn, {t: "tooltips.distance"}),
                      placement: "right",
                      children: (0, r.jsx)("span", {
                        className: "text-gray-800 font-medium",
                        children: s && ya(ga([f, d], [c, l]))
                      })
                    }), (0, r.jsx)("span", {children: "Datarate"}), (0, r.jsx)(fe.Z, {
                      title: "The data rate at which the signal was received.",
                      placement: "right",
                      children: (0, r.jsx)("span", {className: "text-gray-800 font-medium", children: e.datarate})
                    }), (0, r.jsx)("span", {children: "RSSI"}), (0, r.jsx)(fe.Z, {
                      title: "RSSI stands for Received Signal Strength Indicator, and it represents the strength of the signal.",
                      placement: "right",
                      children: (0, r.jsxs)("span", {
                        className: "text-gray-800 font-medium",
                        children: [null === (t = e.signal) || void 0 === t ? void 0 : t.toLocaleString(void 0, {maximumFractionDigits: 2}), "dBm"]
                      })
                    }), (0, r.jsx)("span", {children: "SNR"}), (0, r.jsx)(fe.Z, {
                      title: "SNR stands for Signal-to-Noise Ratio, and it represents the quality of the signal.",
                      placement: "right",
                      children: (0, r.jsxs)("span", {
                        className: "text-gray-800 font-medium",
                        children: [null === (n = e.snr) || void 0 === n ? void 0 : n.toLocaleString(void 0, {maximumFractionDigits: 2}), "dB"]
                      })
                    }), (0, r.jsx)("span", {children: "Frequency"}), (0, r.jsx)(fe.Z, {
                      title: "The frequency at which the signal was received.",
                      placement: "right",
                      children: (0, r.jsxs)("span", {
                        className: "text-gray-800 font-medium",
                        children: [e.frequency.toLocaleString(void 0, {maximumFractionDigits: 1}), " ", "MHz"]
                      })
                    })]
                  })
                })]
              }), (0, r.jsx)(ve, {
                title: e.isValid || e.is_valid ? "VALID" : "INVALID",
                color: e.isValid || e.is_valid ? "green" : "gray",
                tooltip: e.invalidReason
              })]
            }, e.gateway)
          }))
        })]
      })
    };

    function ka(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function Na(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function Sa(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return ka(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return ka(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var Ca = function (e) {
      var t, n = e.txn, s = (0, a.useState)(), i = s[0], o = s[1], l = (0, a.useState)(), c = l[0], u = l[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t, r, a;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.t0 = Sa, e.next = 3, Promise.all([(0, vn.Fc)(n.challenger), (0, vn.Fc)(n.path[0].challengee)]);
            case 3:
              e.t1 = e.sent, t = (0, e.t0)(e.t1, 2), r = t[0], a = t[1], o(r), u(a);
            case 9:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            Na(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Na(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []), (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(yn, {
          title: "Challenger",
          titleIconPath: "/images/challenger-icon.svg",
          hotspot: i
        }), (0, r.jsx)(yn, {
          title: "Beaconer",
          titleIconPath: "/images/poc_receipt_icon.svg",
          hotspot: c
        }), (0, r.jsx)(ba, {path: n.path[0]})]
      })
    }, La = {relay: "yellow", online: "green", offline: "gray"}, Ta = function (e, t) {
      return null === e ? "offline" : function (e) {
        return !!(e && e.length > 0 && e[0].match("p2p-circuit"))
      }(t) ? "relay" : e
    }, Pa = function (e) {
      if (e) {
        var t = e.toString().padStart(10, "0");
        return [parseInt(t.slice(0, 3)), parseInt(t.slice(3, 6)), parseInt(t.slice(6, 10))].join(".")
      }
    }, Aa = {
      relay: "Validators operating behind a relay are not directly reachable and may degrade consensus performance",
      online: "Validator is online",
      offline: "Validator is offline"
    }, Ma = function (e) {
      var t = e.status, n = void 0 === t ? {online: null, listen_addrs: null, height: null} : t, a = n.online,
        s = n.listen_addrs, i = (n.height, Ta(a, s)), o = La[i];
      return (0, r.jsx)(fe.Z, {
        title: Aa[i],
        children: (0, r.jsx)("div", {
          className: ce()("w-2.5 h-2.5 rounded-full", {
            "bg-green-500": "green" === o,
            "bg-gray-550": "gray" === o,
            "bg-yellow-500": "yellow" === o
          })
        })
      })
    }, _a = function (e) {
      var t = e.className;
      return (0, r.jsx)("svg", {
        xmlns: "http://www.w3.org/2000/svg",
        className: ce()(t, {"h-3 w-3 text-txn-heartbeat": !t}),
        viewBox: "0 0 20 20",
        fill: "currentColor",
        children: (0, r.jsx)("path", {
          fillRule: "evenodd",
          d: "M3.172 5.172a4 4 0 015.656 0L10 6.343l1.172-1.171a4 4 0 115.656 5.656L10 17.657l-6.828-6.829a4 4 0 010-5.656z",
          clipRule: "evenodd"
        })
      })
    }, Oa = function (e) {
      var t = e.title, n = e.titleIconPath, a = e.address, s = sn(a).validator;
      return s ? (0, r.jsx)(At, {
        title: n ? (0, r.jsx)(gn, {title: t, iconPath: n}) : t,
        value: (0, r.jsxs)("div", {
          className: "flex items-center space-x-1",
          children: [(0, r.jsx)(Ma, {status: s.status}), (0, r.jsx)("span", {children: bn()(s.address)})]
        }),
        subtitle: (0, r.jsxs)("span", {
          className: "flex items-center space-x-1",
          children: [(0, r.jsx)(_a, {}), (0, r.jsx)("span", {children: Pa(s.versionHeartbeat)})]
        }),
        span: 2,
        linkTo: "/validators/".concat(a)
      }) : (0, r.jsx)(At, {span: 2, isLoading: !0})
    };

    function Ha(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Ia = function (e) {
      var t, n = e.txn, s = (0, a.useState)(), i = s[0], o = s[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, (0, vn.Fc)(n.path[0].challengee);
            case 2:
              t = e.sent, o(t);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            Ha(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Ha(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []), (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(Oa, {
          title: "Challenger",
          titleIconPath: "/images/challenger-icon.svg",
          address: n.challenger
        }), (0, r.jsx)(yn, {
          title: "Beaconer",
          titleIconPath: "/images/poc_receipt_icon.svg",
          hotspot: i
        }), (0, r.jsx)(ba, {path: n.path[0]})]
      })
    }, Ba = n(27864), Ea = function (e) {
      var t = e.address, n = e.size, a = void 0 === n ? 24 : n, s = e.style, i = e.className;
      return (0, r.jsx)(Ba.Rings, {style: s, className: i, size: a, seed: t, circle: !0})
    }, Fa = function (e) {
      var t = e.title, n = e.subtitle, a = e.address, s = e.span, i = void 0 === s ? 2 : s, o = e.truncate,
        l = void 0 === o ? 7 : o, c = e.showSecondHalf, u = void 0 === c || c;
      return a ? (0, r.jsx)(At, {
        title: t,
        value: (0, r.jsxs)("div", {
          className: "flex items-center justify-start",
          children: [(0, r.jsx)(Ea, {address: a}), (0, r.jsx)("span", {
            className: "pl-1",
            children: (0, r.jsx)(he, {address: a, truncate: l, showSecondHalf: u})
          })]
        }),
        subtitle: n,
        span: i,
        linkTo: "/accounts/".concat(a),
        isLoading: !a
      }) : null
    }, Da = function (e) {
      var t = e.txn, n = e.inline;
      return (0, r.jsxs)(Dt, {
        padding: !n,
        children: [(0, r.jsx)(Fa, {title: "Payer", address: t.payer}), (0, r.jsx)(Fa, {
          title: "Payee",
          address: t.payee
        }), (0, r.jsx)(At, {
          title: "Amount of HNT",
          value: t.amount.toString(2),
          span: 2
        }), (0, r.jsx)(At, {title: "Fee", value: t.fee.toString(), span: 2})]
      })
    }, Za = function (e) {
      var t = e.txn, n = e.inline;
      return (0, r.jsxs)(Dt, {
        padding: !n,
        children: [(0, r.jsx)(Fa, {title: "Payer", address: t.payer}), t.payments.map((function (e, t) {
          return (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsx)(Fa, {
              title: "Payee ".concat(t + 1),
              address: e.payee,
              truncate: 5,
              showSecondHalf: !1,
              span: 1
            }), (0, r.jsx)(At, {title: "HNT sent to Payee ".concat(t + 1), value: e.amount.toString(2), span: 1})]
          })
        })), (0, r.jsx)(At, {
          title: "Total HNT",
          value: t.totalAmount.toString(2),
          span: 2
        }), (0, r.jsx)(At, {title: "Fee", value: t.fee.toString(), span: 2})]
      })
    }, Ra = function (e) {
      var t = e.txns, n = e.className, s = e.padding, i = void 0 === s || s, o = (0, c.countBy)(t, "type"),
        l = t.length, u = (0, a.useMemo)((function () {
          return 0 === t.length
        }), [t.length]);
      return (0, r.jsx)("div", {
        className: ce()("bg-white rounded-lg col-span-2", {"pt-3 px-5": i}, n),
        children: (0, r.jsx)("div", {
          className: "h-6 w-full my-3 rounded-lg flex overflow-hidden",
          children: u ? (0, r.jsx)("div", {className: "animate-pulse bg-white w-full"}) : Object.keys(o).sort((function (e, t) {
            return o[t] - o[e]
          })).map((function (e, t) {
            return (0, r.jsx)(fe.Z, {
              placement: "bottom",
              title: "".concat(Yr(e), " (").concat(o[e], ")"),
              children: (0, r.jsx)("div", {
                style: {
                  background: Xr(e),
                  width: (n = o[e], a = l, n / a * 100 + "%"),
                  marginRight: 1
                }
              }, e)
            });
            var n, a
          }))
        })
      })
    }, Ga = n(13428), Va = function (e) {
      var t = e.txn, n = (0, a.useState)([]), s = n[0], i = n[1], l = (0, a.useState)(20), c = l[0], u = l[1],
        d = (0, a.useState)(1), f = d[0], m = d[1], h = f * c, p = h - c, x = s.slice(p, h);
      (0, a.useEffect)((function () {
        var e = [];
        t.rewards.forEach((function (n) {
          var r = {account: n.account};
          if (r.rewards = t.rewards.filter((function (e) {
            return e.account === n.account
          })), 0 === e.filter((function (e) {
            return e.account === r.account
          })).length) {
            r.count = r.rewards.length;
            var a = 0;
            r.rewards.forEach((function (e) {
              a += e.amount.integerBalance / 1e8
            })), r.amount = a, e.push(r)
          }
        })), e.sort((function (e, t) {
          return t.amount > e.amount ? 1 : e.amount > t.amount ? -1 : 0
        })), i(e)
      }), [t.rewards]);
      var v = function (e) {
        var t = e.rewardsRecipients;
        return t.length ? (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsxs)("div", {
            className: "col-span-2",
            children: [(0, r.jsxs)("div", {
              className: "bg-gray-200 p-3 rounded-t-lg col-span-2 text-gray-600 text-sm mb-1",
              children: ["Rewards Recipients (", t.length ? s.length : "Loading...", ")"]
            }), (0, r.jsx)("div", {
              className: "space-y-1 ", children: t.map((function (e) {
                return (0, r.jsx)(g, {rewardInfo: e})
              }))
            })]
          }), (0, r.jsx)("div", {
            className: "bg-gray-300 col-span-2 w-full -mt-3 md:-mt-4 border-t border-navy-500 rounded-b-lg py-2",
            children: (0, r.jsx)(Ga.Z, {
              current: f,
              showSizeChanger: !0,
              showLessItems: !0,
              hideOnSinglePage: !0,
              size: "small",
              total: s.length,
              pageSize: c,
              onChange: function (e, t) {
                m(e), u(t)
              }
            })
          })]
        }) : (0, r.jsx)(me, {className: "w-full"})
      }, g = function (e) {
        var t, n, s = e.rewardInfo, i = (0, a.useState)(!1), l = i[0], c = i[1];
        return (0, r.jsxs)("div", {
          className: "flex flex-col bg-gray-200 p-3", children: [(0, r.jsxs)("div", {
            className: "flex justify-between items-center ",
            children: [(0, r.jsxs)("div", {
              className: "w-full",
              children: [(0, r.jsxs)(o.Link, {
                to: "/accounts/".concat(s.account),
                className: "text-base leading-tight tracking-tight text-navy-1000 hover:text-navy-400 transition-all duration-150 flex items-center justify-start",
                children: [(0, r.jsx)(Ea, {size: 18, address: s.account}), (0, r.jsx)("span", {
                  className: "pl-1 ",
                  children: (0, r.jsx)(he, {address: s.account, truncate: 4})
                })]
              }), (0, r.jsx)("div", {
                className: "flex items-center w-full justify-between text-sm leading-tight tracking-tighter text-gray-600 mt-0.5",
                children: (0, r.jsxs)("p", {
                  className: "flex items-center justify-end text-gray-600 mt-1 mb-0",
                  children: [s.amount.toLocaleString(void 0, {
                    minimumFractionDigits: 2,
                    maximumFractionDigits: 2
                  }), " ", "HNT"]
                })
              })]
            }), (0, r.jsx)("button", {
              className: "flex items-center justify-start transition-all duration-150 outline-none rounded-full border border-gray-400 hover:bg-gray-300 hover:border-gray-700",
              children: (0, r.jsxs)("p", {
                className: "whitespace-nowrap flex items-center justify-end text-gray-600 hover:text-gray-700 text-md my-0 px-3 py-1",
                onClick: function () {
                  c((function (e) {
                    return !e
                  }))
                },
                children: [null === s || void 0 === s || null === (t = s.rewards) || void 0 === t ? void 0 : t.length, " ", 1 === (null === s || void 0 === s || null === (n = s.rewards) || void 0 === n ? void 0 : n.length) ? "Reward" : "Rewards", (0, r.jsx)("span", {
                  className: "ml-1 w-3",
                  children: l ? "-" : "+"
                })]
              })
            })]
          }, s.address), l && (0, r.jsx)("div", {
            className: "my-2", children: s.rewards.map((function (e, t, n) {
              var a = n.length;
              return (0, r.jsxs)("div", {
                className: ce()("bg-gray-300 flex px-2 py-1 items-center justify-between", {
                  "rounded-t-md": 0 === t,
                  "rounded-b-md": t === a - 1
                }),
                children: [(0, r.jsx)("p", {
                  className: "text-gray-700 text-sm my-0",
                  children: e.amount.toString(2)
                }), (0, r.jsx)("p", {className: "text-gray-800 text-sm my-0 font-sans", children: Yr(e.type)})]
              })
            }))
          })]
        })
      };
      return (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsx)("div", {
          className: "px-4 md:px-8 md:pt-4",
          children: (0, r.jsx)(Ra, {padding: !1, txns: t.rewards})
        }), (0, r.jsxs)(Dt, {
          children: [(0, r.jsx)(At, {
            title: "Total Amount",
            value: t.totalAmount.toString(2),
            span: 2,
            className: "-mt-4 md:-mt-6"
          }), (0, r.jsx)(v, {rewardsRecipients: x})]
        })]
      })
    }, Wa = function (e) {
      var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 2;
      if (0 === e) return "0 Bytes";
      var n = 1024, r = t < 0 ? 0 : t, a = ["Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"],
        s = Math.floor(Math.log(e) / Math.log(n));
      return parseFloat((e / Math.pow(n, s)).toFixed(r)) + " " + a[s]
    }, Ua = function (e) {
      var t = e.txn, n = (0, a.useState)(0), s = n[0], i = n[1], l = (0, a.useState)(0), c = l[0], u = l[1],
        d = (0, a.useState)(0), f = d[0], m = d[1], h = (0, a.useState)(0), p = h[0], x = h[1], v = (0, a.useState)([]),
        g = v[0], y = v[1];
      (0, a.useEffect)((function () {
        var e = [], n = 0, r = 0, a = 0;
        t.stateChannel.summaries.forEach((function (t) {
          n += t.numPackets, r += t.numDcs, a += 24 * t.numDcs, e.push({
            client: t.client,
            owner: t.owner,
            numPackets: t.numPackets,
            numDcs: t.numDcs,
            num_bytes: 24 * t.numDcs
          })
        })), e.sort((function (e, t) {
          return t.numDcs > e.numDcs ? 1 : e.numDcs > t.numDcs ? -1 : 0
        }));
        var s = t.stateChannel.summaries.length;
        i(n), m(r), x(a), u(s), y(e)
      }), [t]);
      var j = (0, a.useState)(20), w = j[0], b = j[1], k = (0, a.useState)(1), N = k[0], S = k[1], C = N * w, L = C - w,
        T = g.slice(L, C), P = function (e) {
          var t = e.participants;
          return (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsxs)("div", {
              className: ce()("bg-gray-200 p-3 rounded-lg col-span-2"),
              children: [(0, r.jsxs)("div", {
                className: "text-gray-600 text-sm leading-loose",
                children: [t.length.toLocaleString(), " Participating Hotspots"]
              }), (0, r.jsx)("div", {
                className: "space-y-4", children: T.map((function (e) {
                  return (0, r.jsxs)("div", {
                    className: "flex items-start justify-between w-full",
                    children: [(0, r.jsxs)("div", {
                      className: "flex flex-col items-start justify-start",
                      children: [(0, r.jsx)(o.Link, {
                        to: "/hotspots/".concat(e.client),
                        className: "text-base leading-tight tracking-tight text-navy-1000 hover:text-navy-400 transition-all duration-150",
                        children: bn()(e.client)
                      }), (0, r.jsxs)(o.Link, {
                        to: "/accounts/".concat(e.owner),
                        className: "flex items-center justify-start text-sm leading-tight tracking-tighter text-gray-600 hover:text-navy-400 pt-1",
                        children: [(0, r.jsx)(Ea, {
                          address: e.owner,
                          size: 14,
                          className: "mr-1"
                        }), (0, r.jsx)(he, {mono: !0, address: e.owner, truncate: 5})]
                      })]
                    }), (0, r.jsxs)("div", {
                      className: "flex flex-col items-end justify-center",
                      children: [(0, r.jsx)("div", {
                        className: "text-sm leading-tight tracking-tighter text-navy-400 font-medium",
                        children: (0, r.jsxs)("span", {className: "pl-1.5", children: [e.numDcs.toLocaleString(), " DC"]})
                      }), (0, r.jsxs)("div", {
                        className: "text-sm leading-tight tracking-tighter text-gray-600 pt-1",
                        children: [e.numPackets.toLocaleString(), " ", 1 === e.numPackets ? "packet " : "packets ", (0, r.jsx)("span", {
                          className: "text-navy-600 pl-1.5",
                          children: Wa(e.num_bytes)
                        })]
                      })]
                    })]
                  }, e.client)
                }))
              })]
            }), (0, r.jsx)("div", {
              className: "bg-gray-300 col-span-2 w-full -mt-3 md:-mt-4 border-t border-navy-500 rounded-b-lg py-2",
              children: (0, r.jsx)(Ga.Z, {
                current: N,
                showSizeChanger: !0,
                showLessItems: !0,
                size: "small",
                total: g.length,
                pageSize: w,
                onChange: function (e, t) {
                  S(e), b(t)
                }
              })
            })]
          })
        };
      return (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(At, {
          title: "Total Packets",
          value: s.toLocaleString()
        }), (0, r.jsx)(At, {title: "Total Data", value: Wa(p)}), (0, r.jsx)(At, {
          title: "Total DC Spent",
          value: f.toLocaleString()
        }), (0, r.jsx)(At, {
          title: "Number of Hotspots",
          value: c.toLocaleString()
        }), (0, r.jsx)(At, {
          title: "State Channel ID",
          value: t.stateChannel.id,
          span: 2
        }), (0, r.jsx)(Fa, {
          title: "State Channel Closer",
          address: t.closer
        }), (0, r.jsx)(Fa, {
          title: "State Channel Owner",
          address: t.stateChannel.owner
        }), (0, r.jsx)(P, {participants: g})]
      })
    }, za = function (e) {
      var t = e.txn, n = e.inline;
      return (0, r.jsxs)(Dt, {
        padding: !n,
        children: [(0, r.jsx)(Fa, {title: "Owner", address: t.owner}), (0, r.jsx)(At, {
          title: "OUI",
          value: t.oui
        }), (0, r.jsx)(At, {title: "Nonce", value: t.nonce}), (0, r.jsx)(At, {
          title: "ID",
          value: t.id,
          span: 2
        }), (0, r.jsx)(At, {
          title: "Expire within",
          value: "".concat(t.expireWithin, " Blocks")
        }), (0, r.jsx)(At, {title: "Fee", value: t.fee.toString(2)}), (0, r.jsx)(At, {
          title: "Amount",
          value: t.amount.toString(2)
        })]
      })
    };

    function Ka(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var qa = function (e) {
      var t, n = e.txn, s = e.inline, i = (0, a.useState)(), o = i[0], l = i[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, (0, vn.Fc)(n.gateway);
            case 2:
              t = e.sent, l(t);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            Ka(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Ka(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), [n.gateway]), (0, r.jsxs)(Dt, {
        padding: !s,
        children: [o ? (0, r.jsx)(yn, {
          title: "Transferred Hotspot",
          hotspot: o
        }) : (0, r.jsx)(At, {
          title: "Transferred Hotspot",
          value: bn()(n.gateway),
          span: 2,
          change: (0, r.jsx)(me, {className: "w-1/3"})
        }), (0, r.jsx)(Fa, {title: "Seller", address: n.seller}), (0, r.jsx)(Fa, {
          title: "Buyer",
          address: n.buyer
        }), (0, r.jsx)(At, {
          title: "Payment to Seller",
          value: n.amountToSeller.toString(2)
        }), (0, r.jsx)(At, {title: "Fee", value: n.fee.toString()})]
      })
    };

    function $a(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Ja = function (e) {
      var t, n = e.txn, s = e.inline, i = (0, a.useState)(), o = i[0], l = i[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, (0, vn.Fc)(n.gateway);
            case 2:
              t = e.sent, l(t);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            $a(s, r, a, i, o, "next", e)
          }

          function o(e) {
            $a(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), [n.gateway]), (0, r.jsxs)(Dt, {
        padding: !s,
        children: [o ? (0, r.jsx)(yn, {
          title: "Transferred Hotspot",
          hotspot: o
        }) : (0, r.jsx)(At, {
          title: "Transferred Hotspot",
          value: bn()(n.gateway),
          span: 2,
          change: (0, r.jsx)(me, {className: "w-1/3"})
        }), (0, r.jsx)(Fa, {title: "Previous Owner", address: n.owner}), (0, r.jsx)(Fa, {
          title: "New Owner",
          address: n.newOwner
        }), (0, r.jsx)(At, {title: "Fee", value: n.fee.toString()})]
      })
    };

    function Ya(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Xa = function (e) {
      var t = e.members;
      return (0, r.jsxs)("div", {
        className: ce()("bg-gray-200 p-3 rounded-lg col-span-2"),
        children: [(0, r.jsxs)("div", {
          className: "text-gray-600 text-sm leading-loose",
          children: [t.length, " Consensus Group Members"]
        }), (0, r.jsx)("div", {
          className: "space-y-3", children: t.map((function (e) {
            return (0, r.jsx)("div", {
              className: "flex justify-between items-center",
              children: (0, r.jsxs)("div", {
                className: "w-full",
                children: [(0, r.jsx)(o.Link, {
                  to: "/hotspots/".concat(e.address),
                  className: "text-base leading-tight tracking-tight text-navy-1000 hover:text-navy-400 transition-all duration-150",
                  children: bn()(e.address)
                }), (0, r.jsxs)("div", {
                  className: "flex items-center w-full justify-between text-sm leading-tight tracking-tighter text-gray-600",
                  children: [(0, r.jsx)("div", {
                    className: "",
                    children: e.geocode && (0, r.jsx)(de, {geocode: e.geocode})
                  }), (0, r.jsxs)(o.Link, {
                    to: "/accounts/".concat(e.owner),
                    className: "flex items-center justify-end text-gray-600 hover:text-navy-400",
                    children: [(0, r.jsx)(Ea, {size: 17, address: e.owner}), (0, r.jsx)("span", {
                      className: "pl-1 ",
                      children: (0, r.jsx)(he, {address: e.owner, truncate: 4, mono: !0})
                    })]
                  })]
                })]
              })
            }, e.address)
          }))
        })]
      })
    }, Qa = function (e) {
      var t, n = e.txn, s = e.inline, i = (0, a.useState)([]), o = i[0], l = i[1], c = (0, a.useState)(!1), u = c[0],
        d = c[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return d(!0), e.next = 3, (0, vn.ex)(n.height);
            case 3:
              t = e.sent, l(t), d(!1);
            case 6:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            Ya(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Ya(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []), (0, r.jsxs)(Dt, {
        padding: !s,
        children: [(0, r.jsx)(Xa, {members: o}), (0, r.jsx)(At, {
          title: "Delay",
          value: n.delay,
          span: 2,
          isLoading: u
        }), (0, r.jsx)(At, {title: "Proof", value: G(n.proof, 10), copyableValue: n.proof, isLoading: u, span: 2})]
      })
    };

    function es(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var ts = "14fzfjFcHpDR1rTH8BNPvSi5dKBbgxaDnmsVPbCjuq9ENjpZbxh", ns = "Helium Inc (Old)", rs = function () {
      var e, t = (e = f().mark((function e(t) {
        var n, r, a, s, i;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              if (t && void 0 !== t) {
                e.next = 2;
                break
              }
              return e.abrupt("return", "");
            case 2:
              if (t !== ts) {
                e.next = 4;
                break
              }
              return e.abrupt("return", ns);
            case 4:
              return e.next = 6, fetch("https://onboarding.dewi.org/api/v2/makers");
            case 6:
              return n = e.sent, e.next = 9, n.json();
            case 9:
              return r = e.sent, a = r.data, s = a.find((function (e) {
                return e.address === t
              })), i = void 0 !== s ? s.name : "Unknown Maker", e.abrupt("return", i);
            case 14:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            es(s, r, a, i, o, "next", e)
          }

          function o(e) {
            es(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      });
      return function (e) {
        return t.apply(this, arguments)
      }
    }();

    function as(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var ss = function (e) {
      var t, n = e.txn, s = e.inline, i = (0, a.useState)(), o = i[0], l = i[1], c = (0, a.useState)(), u = c[0],
        d = c[1], m = (0, a.useState)(!1), h = m[0], p = m[1];
      (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return p(!0), e.next = 3, (0, vn.Fc)(n.gateway);
            case 3:
              if (t = e.sent, n.payer !== n.owner && null !== n.payer) {
                e.next = 8;
                break
              }
              d("Hotspot Owner"), e.next = 13;
              break;
            case 8:
              return e.t0 = d, e.next = 11, rs(n.payer);
            case 11:
              e.t1 = e.sent, (0, e.t0)(e.t1);
            case 13:
              l(t), p(!1);
            case 15:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            as(s, r, a, i, o, "next", e)
          }

          function o(e) {
            as(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []);
      var x = n.payer === n.owner || null === n.payer ? n.owner : n.payer;
      return (0, r.jsxs)(Dt, {
        padding: !s,
        children: [(0, r.jsx)(yn, {hotspot: o, title: "Added Hotspot", isLoading: h}), (0, r.jsx)(Fa, {
          address: n.owner,
          title: "Added Hotspot Owner",
          isLoading: h
        }), (0, r.jsx)(At, {
          title: "Staking Fee",
          value: n.stakingFee.toString(),
          span: 2,
          isLoading: h
        }), (0, r.jsx)(Fa, {
          title: "Staking Fee Payer",
          subtitle: (0, r.jsx)("span", {className: "text-gray-700", children: u}),
          address: x,
          isLoading: h
        }), (0, r.jsx)(At, {title: "Fee", value: n.fee.toString(), isLoading: h, span: 2})]
      })
    };

    function is(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var os = function (e) {
      var t, n = e.txn, s = e.inline, i = (0, a.useState)(), o = i[0], l = i[1], c = (0, a.useState)(), u = c[0],
        d = c[1], m = (0, a.useState)(!1), h = m[0], p = m[1];
      (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return p(!0), e.next = 3, (0, vn.Fc)(n.gateway);
            case 3:
              if (t = e.sent, n.payer !== n.owner && null !== n.payer) {
                e.next = 8;
                break
              }
              d("Hotspot Owner"), e.next = 13;
              break;
            case 8:
              return e.t0 = d, e.next = 11, rs(n.payer);
            case 11:
              e.t1 = e.sent, (0, e.t0)(e.t1);
            case 13:
              l(t), p(!1);
            case 15:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            is(s, r, a, i, o, "next", e)
          }

          function o(e) {
            is(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []);
      var x = n.payer === n.owner || null === n.payer ? n.owner : n.payer;
      return (0, r.jsxs)(Dt, {
        padding: !s,
        children: [(0, r.jsx)(yn, {
          hotspot: o,
          title: "Asserted Hotspot",
          isLoading: h
        }), (0, r.jsx)(Fa, {
          address: n.owner,
          title: "Asserted Hotspot Owner",
          isLoading: h
        }), (0, r.jsx)(At, {
          title: "Staking Fee",
          value: n.stakingFee.toString(),
          span: 2,
          isLoading: h
        }), (0, r.jsx)(Fa, {
          title: "Staking Fee Payer",
          subtitle: (0, r.jsx)("span", {className: "text-gray-700", children: u}),
          address: x,
          isLoading: h
        }), n.lat && n.lng && (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)(At, {
            title: "Asserted Latitude",
            value: n.lat,
            isLoading: h
          }), (0, r.jsx)(At, {title: "Asserted Longitude", value: n.lng, isLoading: h})]
        }), (0, r.jsx)(At, {title: "Nonce", value: n.nonce, isLoading: h}), (0, r.jsx)(At, {
          title: "Fee",
          value: n.fee.toString(),
          isLoading: h
        })]
      })
    };

    function ls(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var cs = function (e) {
      var t, n = e.txn, s = e.inline, i = (0, a.useState)(), o = i[0], l = i[1], c = (0, a.useState)(), u = c[0],
        d = c[1], m = (0, a.useState)(!1), h = m[0], p = m[1];
      (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return p(!0), e.next = 3, (0, vn.Fc)(n.gateway);
            case 3:
              if (t = e.sent, n.payer !== n.owner && null !== n.payer) {
                e.next = 8;
                break
              }
              d("Hotspot Owner"), e.next = 13;
              break;
            case 8:
              return e.t0 = d, e.next = 11, rs(n.payer);
            case 11:
              e.t1 = e.sent, (0, e.t0)(e.t1);
            case 13:
              l(t), p(!1);
            case 15:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            ls(s, r, a, i, o, "next", e)
          }

          function o(e) {
            ls(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []);
      var x = n.payer === n.owner || null === n.payer ? n.owner : n.payer;
      return (0, r.jsxs)(Dt, {
        padding: !s,
        children: [(0, r.jsx)(yn, {
          hotspot: o,
          title: "Asserted Hotspot",
          isLoading: h
        }), (0, r.jsx)(Fa, {
          address: n.owner,
          title: "Asserted Hotspot Owner",
          isLoading: h
        }), (0, r.jsx)(At, {
          title: "Staking Fee",
          value: n.stakingFee.toString(),
          span: 2,
          isLoading: h
        }), (0, r.jsx)(Fa, {
          title: "Staking Fee Payer",
          subtitle: (0, r.jsx)("span", {className: "text-gray-700", children: u}),
          address: x,
          isLoading: h
        }), n.lat && n.lng && (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)(At, {
            title: "Asserted Latitude",
            value: n.lat,
            isLoading: h
          }), (0, r.jsx)(At, {title: "Asserted Longitude", value: n.lng, isLoading: h})]
        }), (0, r.jsx)(At, {
          title: "Elevation",
          value: (0, ae.Fu)(n.elevation),
          isLoading: h
        }), (0, r.jsx)(At, {title: "Gain", value: (0, ae.y4)(n.gain), isLoading: h}), (0, r.jsx)(At, {
          title: "Nonce",
          value: n.nonce,
          isLoading: h
        }), (0, r.jsx)(At, {title: "Fee", value: n.fee.toString(), isLoading: h})]
      })
    };

    function us(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var ds = function (e) {
      var t, n = e.txn, s = e.inline, i = (0, a.useState)(), o = i[0], l = i[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, (0, vn.Fc)(n.challenger);
            case 2:
              t = e.sent, l(t);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            us(s, r, a, i, o, "next", e)
          }

          function o(e) {
            us(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []), (0, r.jsxs)(Dt, {
        padding: !s,
        children: [(0, r.jsx)(yn, {title: "Challenger Hotspot", hotspot: o}), (0, r.jsx)(Fa, {
          title: "Challenger Owner",
          address: n.challengerOwner
        }), (0, r.jsx)(At, {title: "Version", value: n.version}), (0, r.jsx)(At, {
          title: "Fee",
          value: n.fee.toString()
        }), (0, r.jsx)(At, {
          title: "Secret Hash",
          value: n.secretHash,
          copyableValue: n.secretHash,
          span: 2
        }), (0, r.jsx)(At, {
          title: "Onion Key Hash",
          value: n.onionKeyHash,
          copyableValue: n.onionKeyHash,
          span: 2
        }), (0, r.jsx)(At, {title: "Block Hash", value: n.blockHash, span: 2, copyableValue: n.blockHash})]
      })
    };

    function fs(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function ms(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return fs(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return fs(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var hs = function (e) {
      var t = e.title, n = e.value;
      if (null === n) return (0, r.jsx)(At, {title: t, value: "null", span: 2, emptyValue: !0});
      if (Array.isArray(n)) {
        if (0 === n.length) return (0, r.jsx)(At, {title: t, value: "Empty array", span: 2, emptyValue: !0});
        n.map((function (e, t) {
          return (0, r.jsx)(At, {title: t, value: JSON.stringify(e), span: 2})
        }))
      }
      return (0, r.jsxs)("div", {
        className: ce()("bg-gray-200 p-3 rounded-lg col-span-2"),
        children: [(0, r.jsx)("div", {
          className: "text-xl font-medium text-black my-1.5 tracking-tight w-full break-all pb-4",
          children: t
        }), (0, r.jsx)("div", {
          className: "space-y-2 break-all", children: Object.entries(n).map((function (e) {
            var t = ms(e, 2), n = t[0], a = t[1];
            return "object" === typeof a ? (0, r.jsx)(hs, {
              title: n,
              value: a
            }) : (0, r.jsx)("div", {
              className: "flex justify-between items-center",
              children: (0, r.jsxs)("div", {
                children: [(0, r.jsx)("div", {
                  className: "text-base leading-tight tracking-tight",
                  children: n
                }), (0, r.jsx)("div", {
                  className: "text-sm leading-tight tracking-tighter text-gray-600 break-all",
                  children: a
                })]
              })
            }, n)
          }))
        })]
      })
    }, ps = function (e) {
      var t = e.txn, n = e.inline;
      return (0, r.jsx)(r.Fragment, {
        children: (0, r.jsx)(Dt, {
          padding: !n,
          children: Object.entries(t).map((function (e) {
            var t = ms(e, 2), n = t[0], a = t[1];
            return "type" === n || "time" === n || "height" === n || "hash" === n || "name" === n || "color" === n || "tooltip" === n ? null : "payer" === n || "payee" === n || "owner" === n ? "undefined" === a ? (0, r.jsx)(At, {
              title: n,
              value: a,
              span: 2,
              emptyValue: !0
            }) : (0, r.jsx)(Fa, {
              title: n,
              address: a,
              span: 2
            }) : "amount" === n || "fee" === n || "stakingFee" === n ? 0 === a ? (0, r.jsx)(At, {
              title: n,
              value: a,
              span: 2
            }) : (0, r.jsx)(At, {
              title: n,
              value: a.toString(2),
              span: 2
            }) : "object" === typeof a ? (0, r.jsx)(hs, {title: n, value: a}) : "" === a ? (0, r.jsx)(At, {
              title: n,
              span: 2,
              value: "Empty string",
              emptyValue: !0
            }) : (0, r.jsx)(At, {title: n, span: 2, value: a})
          }))
        })
      })
    };

    function xs(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var vs = function (e) {
      var t, n = e.txn, s = e.inline, i = (0, a.useState)(), o = i[0], l = i[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.oracle.getPriceAtBlock(n.height);
            case 2:
              t = e.sent.price, l(t);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            xs(s, r, a, i, o, "next", e)
          }

          function o(e) {
            xs(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []), (0, r.jsxs)(Dt, {
        padding: !s,
        children: [(0, r.jsx)(Fa, {title: "Payer", address: n.payer}), (0, r.jsx)(Fa, {
          title: "Payee",
          address: n.payee
        }), (0, r.jsx)(At, {
          title: "Amount Burned",
          span: 2,
          value: n.amount.toString(2)
        }), (0, r.jsx)(At, {
          title: "Oracle Price",
          isLoading: !o,
          value: null === o || void 0 === o ? void 0 : o.toString(2)
        }), (0, r.jsx)(At, {
          title: "Value",
          isLoading: !o,
          value: o ? n.amount.toUsd(o).toString(2) : "Loading..."
        }), (0, r.jsx)(At, {title: "Fee", value: n.fee.toString(2)}), (0, r.jsx)(At, {
          title: "Nonce",
          value: n.nonce
        }), (0, r.jsx)(At, {title: "Memo", span: 2, value: n.memo, copyableValue: n.memo})]
      })
    }, gs = function (e) {
      var t = e.txn, n = e.inline;
      return (0, r.jsxs)(Dt, {
        padding: !n,
        children: [(0, r.jsx)(Fa, {title: "Owner", address: t.owner}), (0, r.jsx)(At, {
          title: "Stake",
          value: t.stake.toString(2)
        }), (0, r.jsx)(At, {title: "Fee", value: t.fee.toString()}), (0, r.jsx)(Oa, {
          title: "Validator",
          address: t.address
        }), (0, r.jsx)(At, {
          title: "Owner Signature",
          value: t.ownerSignature,
          copyableValue: t.ownerSignature,
          span: 2
        })]
      })
    }, ys = function (e) {
      var t = e.txn, n = e.inline;
      return (0, r.jsxs)(Dt, {
        padding: !n,
        children: [(0, r.jsx)(At, {title: "Stake", value: t.stakeAmount.toString(2)}), (0, r.jsx)(At, {
          title: "Fee",
          value: t.fee.toString()
        }), (0, r.jsx)(Oa, {title: "Old Address", address: t.oldAddress}), (0, r.jsx)(Fa, {
          title: "Old Owner",
          address: t.oldOwner
        }), (0, r.jsx)(At, {
          title: "Old Owner Signature",
          value: t.oldOwnerSignature,
          copyableValue: t.oldOwnerSignature,
          span: 2
        }), (0, r.jsx)(Oa, {title: "New Address", address: t.newAddress}), (0, r.jsx)(At, {
          title: "New Owner",
          value: t.newOwner,
          span: 2
        }), (0, r.jsx)(At, {
          title: "New Owner Signature",
          value: t.newOwnerSignature,
          copyableValue: t.newOwnerSignature,
          span: 2
        })]
      })
    }, js = function (e) {
      var t = e.txn, n = e.inline;
      return (0, r.jsxs)(Dt, {
        padding: !n,
        children: [(0, r.jsx)(Oa, {title: "Validator", address: t.address}), (0, r.jsx)(At, {
          title: "Version",
          value: Pa(t.version),
          span: 2
        }), (0, r.jsx)(At, {title: "Raw Version Text", value: t.version, span: 2}), (0, r.jsx)(At, {
          title: "Signature",
          value: t.signature,
          copyableValue: t.signature,
          span: 2
        })]
      })
    }, ws = function (e) {
      var t = e.txn, n = e.isLoading, a = e.inline, s = void 0 !== a && a;
      if (n) return null;
      var i = function (e) {
        switch (e.type) {
          case"poc_receipts_v1":
            return Ca;
          case"poc_receipts_v2":
            return Ia;
          case"payment_v1":
            return Da;
          case"payment_v2":
            return Za;
          case"poc_request_v1":
            return ds;
          case"rewards_v1":
          case"rewards_v2":
          case"rewards_v3":
            return Va;
          case"consensus_group_v1":
            return Qa;
          case"state_channel_close_v1":
            return Ua;
          case"state_channel_open_v1":
            return za;
          case"transfer_hotspot_v1":
            return qa;
          case"transfer_hotspot_v2":
            return Ja;
          case"add_gateway_v1":
            return ss;
          case"assert_location_v1":
            return os;
          case"assert_location_v2":
            return cs;
          case"token_burn_v1":
            return vs;
          case"stake_validator_v1":
            return gs;
          case"transfer_validator_stake_v1":
            return ys;
          case"validator_heartbeat_v1":
            return js;
          default:
            return ps
        }
      }(t);
      return (0, r.jsx)(i, {txn: t, inline: s})
    }, bs = function (e) {
      var t = e.txn, n = e.role, a = (e.address, t.amount.toString(2)), s = "payer" === n, i = s ? t.payee : t.payer;
      return (0, r.jsxs)("span", {
        className: "flex items-center",
        children: [(0, r.jsx)("img", {
          alt: "",
          src: "/images/hnt.svg",
          className: "w-4 mr-1"
        }), (0, r.jsxs)("span", {
          className: "text-xs font-sans font-light tracking-tight flex items-center justify-start",
          children: [a, " ", s ? "to" : "from", (0, r.jsx)("div", {
            className: "ml-1",
            children: (0, r.jsxs)("span", {
              className: "flex flex-row items-center justify-start space-x-0.5 ml-1",
              children: [(0, r.jsx)(Ea, {address: i, size: 12}), (0, r.jsx)(he, {
                showSecondHalf: !1,
                mono: !0,
                address: i,
                truncate: 4
              })]
            })
          })]
        })]
      })
    }, ks = function (e) {
      var t = e.txn, n = e.address, a = e.role;
      if ("payee" === a) {
        var s = 1 === t.payments.length ? t.totalAmount.toString(2) : t.payments.find((function (e) {
          return e.payee === n
        })).amount.toString(2);
        return (0, r.jsxs)("span", {
          className: "flex items-center",
          children: [(0, r.jsx)("img", {
            alt: "",
            src: "/images/hnt.svg",
            className: "w-4 mr-1"
          }), (0, r.jsxs)("span", {
            className: "text-xs font-sans font-light tracking-tight flex items-center justify-start",
            children: [s, " from", (0, r.jsx)("div", {
              className: "ml-1",
              children: (0, r.jsxs)("span", {
                className: "flex flex-row items-center justify-start space-x-0.5",
                children: [(0, r.jsx)(Ea, {address: t.payer, size: 12}), (0, r.jsx)(he, {
                  showSecondHalf: !1,
                  mono: !0,
                  address: t.payer,
                  truncate: 5
                })]
              })
            })]
          })]
        })
      }
      if ("payer" === a) {
        var i, o = t.totalAmount.toString(3);
        return (0, r.jsxs)("span", {
          className: "flex items-center",
          children: [(0, r.jsx)("img", {
            alt: "",
            src: "/images/hnt.svg",
            className: "w-4 mr-1"
          }), (0, r.jsxs)("span", {
            className: "text-xs font-sans font-light tracking-tight flex items-center justify-start",
            children: [o, " to", (0, r.jsx)("div", {
              className: "ml-1",
              children: 1 === (null === t || void 0 === t || null === (i = t.payments) || void 0 === i ? void 0 : i.length) ? (0, r.jsxs)("span", {
                className: "flex flex-row items-center justify-start space-x-0.5",
                children: [(0, r.jsx)(Ea, {address: t.payments[0].payee, size: 12}), (0, r.jsx)(he, {
                  showSecondHalf: !1,
                  mono: !0,
                  address: t.payments[0].payee,
                  truncate: 4
                })]
              }) : "multiple recipients"
            })]
          })]
        })
      }
    };

    function Ns(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function Ss(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return Ns(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return Ns(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var Cs = function (e) {
      var t = e.txn, n = e.address, a = e.role;
      if ("witness" === a) {
        var s = ta(t, n), i = t.path[0].witnesses.find((function (e) {
          return e.gateway === n
        }));
        if ("poc_witnesses_invalid" === s) return (0, r.jsxs)("span", {
          className: "text-xs font-sans font-semibold text-red-500",
          children: ["Invalid Witness:", " ", na(null === i || void 0 === i ? void 0 : i.invalidReason)]
        });
        if ("poc_witnesses_valid" === s) {
          var o, l, c = t.path[0].challengeeLocationHex, u = Ss((0, H.h3ToGeo)(c), 2), d = u[0], f = u[1],
            m = Ss((0, H.h3ToGeo)(i.locationHex), 2), h = m[0], p = m[1];
          return (0, r.jsx)("div", {
            className: "flex flex-row items-center justify-start w-full",
            children: (0, r.jsxs)("p", {
              className: "font-extralight text-xs text-gray-700 tracking-tighter",
              children: [(0, r.jsx)("span", {
                className: "text-gray-800 font-normal",
                children: f && ya(ga([f, d], [p, h]))
              }), (0, r.jsx)("span", {
                className: "inline-flex mx-1 md:mx-1.5",
                children: " | "
              }), (0, r.jsxs)("span", {
                className: "text-gray-800 font-normal",
                children: [i.signal && "".concat(null === (o = i.signal) || void 0 === o ? void 0 : o.toLocaleString(void 0, {maximumFractionDigits: 2}), "\n              dBm"), " ", "RSSI"]
              }), (0, r.jsx)("span", {
                className: "inline-flex mx-1 md:mx-1.5",
                children: " | "
              }), (0, r.jsxs)("span", {
                className: "text-gray-800 font-normal",
                children: [i.snr && "".concat(null === (l = i.snr) || void 0 === l ? void 0 : l.toLocaleString(void 0, {maximumFractionDigits: 2}), "\n          dB"), " ", "SNR"]
              })]
            })
          })
        }
      } else {
        if ("challengee" === a) return (0, r.jsxs)("div", {
          className: "flex flex-row items-center justify-start space-x-2",
          children: [(0, r.jsxs)("div", {
            className: "flex items-center justify-center",
            children: [(0, r.jsx)("img", {
              src: "/images/witness-yellow-mini.svg",
              className: "w-3.5 h-auto",
              alt: ""
            }), (0, r.jsx)("span", {
              className: "text-xs font-sans font-light text-black ml-1",
              children: null === t || void 0 === t ? void 0 : t.numberOfValidWitnesses
            })]
          }), (0, r.jsxs)("div", {
            className: "flex items-center justify-center",
            children: [(0, r.jsx)("img", {
              src: "/images/witness-gray.svg",
              className: "w-3.5 h-auto",
              alt: ""
            }), (0, r.jsx)("span", {
              className: "text-xs font-sans font-light text-black ml-1",
              children: null === t || void 0 === t ? void 0 : t.numberOfInvalidWitnesses
            })]
          }), (0, r.jsx)("span", {
            className: "text-xs font-sans font-light text-black ml-1",
            children: (0, r.jsx)(de, {geocode: t.path[0].geocode, condensedView: !0})
          })]
        });
        if ("challenger" === a) return (0, r.jsx)("div", {
          className: "flex flex-row items-center justify-start space-x-2 text-xs",
          children: (0, r.jsx)(de, {geocode: t.path[0].geocode, condensedView: !0})
        })
      }
    }, Ls = function (e) {
      var t = e.txn;
      e.address, e.role;
      return (0, r.jsxs)("span", {
        className: "flex items-center",
        children: [(0, r.jsx)("img", {
          alt: "",
          src: "/images/hnt.svg",
          className: "w-4 mr-1"
        }), (0, r.jsxs)("span", {
          className: "text-xs font-sans font-light tracking-tight",
          children: ["+", t.totalAmount.toString(3)]
        })]
      })
    }, Ts = function (e) {
      var t = e.txn;
      e.role, e.address;
      return (0, r.jsx)("span", {
        className: "flex items-center",
        children: t.stateChannel.summaries.map((function (e, t) {
          return (0, r.jsx)("span", {
            className: "mr-1 w-full py-1 flex rounded-md justify-start items-center",
            children: (0, r.jsxs)("div", {
              className: "flex items-start justify-center flex-row space-x-1",
              children: [(0, r.jsxs)("span", {
                className: "text-gray-800 font-sans text-xs whitespace-nowrap",
                children: [e.numPackets, " packets"]
              }), (0, r.jsx)("span", {
                className: "text-gray-800 font-sans text-xs font-extralight",
                children: "|"
              }), (0, r.jsxs)("span", {
                className: "flex flex-row items-center justify-start w-full space-x-1",
                children: [(0, r.jsx)("img", {
                  src: "/images/dc.svg",
                  alt: "",
                  className: "w-2.5 h-auto"
                }), (0, r.jsxs)("span", {
                  className: "text-gray-800 font-sans text-xs font-light",
                  children: [e.numDcs, " DC"]
                })]
              }), (0, r.jsx)("span", {
                className: "text-gray-800 font-sans text-xs font-extralight",
                children: "|"
              }), (0, r.jsx)("span", {
                className: "text-gray-800 font-sans text-xs whitespace-nowrap",
                children: Wa(24 * e.numDcs)
              })]
            })
          }, t)
        }))
      })
    }, Ps = function (e) {
      var t = e.txn;
      e.role, e.address;
      return (0, r.jsxs)("span", {
        className: "flex items-center justify-start",
        children: [(0, r.jsx)(_a, {className: "h-3.5 w-auto mb-0.5 text-txn-heartbeat"}), (0, r.jsx)("span", {
          className: "ml-0.5 text-xs font-sans font-light tracking-tight flex items-center justify-start",
          children: Pa(t.version)
        })]
      })
    }, As = function (e) {
      var t = e.txn, n = (e.role, e.address), a = t.seller === n, s = a ? t.buyer : t.seller;
      return (0, r.jsx)("span", {
        className: "flex items-center",
        children: (0, r.jsxs)("span", {
          className: "text-xs font-sans font-light tracking-tight flex items-center justify-start",
          children: ["".concat(a ? "Sent" : "Received", " ").concat(bn()(t.gateway), " ").concat(a ? "to" : "from"), (0, r.jsx)("div", {
            className: "ml-1",
            children: (0, r.jsxs)("span", {
              className: "flex flex-row items-center justify-start space-x-0.5 ml-1",
              children: [(0, r.jsx)(Ea, {address: s, size: 12}), (0, r.jsx)(he, {
                showSecondHalf: !1,
                mono: !0,
                address: s,
                truncate: 4
              })]
            })
          })]
        })
      })
    }, Ms = function (e) {
      var t = e.txn, n = (e.role, e.address), a = t.owner === n, s = a ? t.newOwner : t.owner;
      return (0, r.jsx)("span", {
        className: "flex items-center",
        children: (0, r.jsxs)("span", {
          className: "text-xs font-sans font-light tracking-tight flex items-center justify-start",
          children: ["".concat(a ? "Sent" : "Received", " ").concat(bn()(t.gateway), " ").concat(a ? "to" : "from"), (0, r.jsx)("div", {
            className: "ml-1",
            children: (0, r.jsxs)("span", {
              className: "flex flex-row items-center justify-start space-x-0.5 ml-1",
              children: [(0, r.jsx)(Ea, {address: s, size: 12}), (0, r.jsx)(he, {
                showSecondHalf: !1,
                mono: !0,
                address: s,
                truncate: 4
              })]
            })
          })]
        })
      })
    }, _s = function (e) {
      var t = e.txn, n = e.address, a = e.role;
      if (e.detailsLoading) return (0, r.jsx)(me, {className: "w-1/2 opacity-80"});
      var s = function (e) {
        switch (e.type) {
          case"payment_v1":
            return bs;
          case"payment_v2":
            return ks;
          case"poc_receipts_v1":
          case"poc_receipts_v2":
            return Cs;
          case"rewards_v1":
          case"rewards_v2":
          case"rewards_v3":
            return Ls;
          case"state_channel_close_v1":
            return Ts;
          case"validator_heartbeat_v1":
            return Ps;
          case"transfer_hotspot_v1":
            return As;
          case"transfer_hotspot_v2":
            return Ms;
          default:
            return null
        }
      }(t);
      return (0, r.jsx)("div", {className: "opacity-80", children: (0, r.jsx)(s, {txn: t, address: n, role: a})})
    }, Os = (0, a.memo)(_s), Hs = function (e) {
      var t = e.className;
      return (0, r.jsx)("svg", {
        className: ce()(t, {"w-6 h-6": !t}),
        fill: "none",
        stroke: "currentColor",
        viewBox: "0 0 24 24",
        xmlns: "http://www.w3.org/2000/svg",
        children: (0, r.jsx)("path", {
          strokeLinecap: "round",
          strokeLinejoin: "round",
          strokeWidth: "2",
          d: "M14 5l7 7m0 0l-7 7m7-7H3"
        })
      })
    };

    function Is(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function Bs(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return Is(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return Is(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var Es = function (e) {
      var t, n, a = e.activeWitness, s = e.path.challengeeLocationHex, i = Bs((0, H.h3ToGeo)(s), 2), o = i[0], l = i[1],
        c = Bs((0, H.h3ToGeo)(a.locationHex), 2), u = c[0], d = c[1];
      return (0, r.jsxs)("div", {
        className: "grid grid-cols-8 text-xs font-sans font-thin text-gray-800 px-4 py-2 whitespace-nowrap bg-bluegray-50 rounded-md mt-2",
        children: [(0, r.jsx)("span", {
          className: "col-span-2",
          children: "Distance"
        }), (0, r.jsx)("span", {
          className: "col-span-2 text-gray-800 font-medium ml-0.5",
          children: l && ya(ga([l, o], [d, u]))
        }), (0, r.jsx)("span", {
          className: "col-span-2",
          children: "RSSI"
        }), (0, r.jsx)("span", {
          className: "col-span-2 text-gray-800 font-medium ml-0.5",
          children: a.signal && "".concat(null === (t = a.signal) || void 0 === t ? void 0 : t.toLocaleString(void 0, {maximumFractionDigits: 2}), "\n            dBm")
        }), (0, r.jsx)("span", {
          className: "col-span-2",
          children: "SNR"
        }), (0, r.jsx)("span", {
          className: "col-span-2 text-gray-800 font-medium ml-0.5",
          children: a.snr && "".concat(null === (n = a.snr) || void 0 === n ? void 0 : n.toLocaleString(void 0, {maximumFractionDigits: 2}), "\n            dB")
        }), (0, r.jsx)("span", {
          className: "col-span-2",
          children: "Frequency"
        }), (0, r.jsx)("span", {
          className: "col-span-2 text-gray-800 font-medium ml-0.5",
          children: a.frequency && "".concat(a.frequency.toLocaleString(void 0, {maximumFractionDigits: 1}), " MHz")
        })]
      })
    }, Fs = function (e) {
      var t = e.txn, n = e.role, a = e.address, s = e.isWitness, i = t.path[0].witnesses.find((function (e) {
        return e.gateway === a
      }));
      return (0, r.jsxs)("div", {
        className: "flex flex-col mr-4 w-full",
        children: ["poc_witnesses_invalid" === n && (0, r.jsxs)("span", {
          className: "text-xs font-sans font-semibold text-red-500 mt-0 mb-2 ml-[22px]",
          children: ["Invalid Witness:", " ", na(null === i || void 0 === i ? void 0 : i.invalidReason)]
        }), s && (0, r.jsx)(Es, {activeWitness: i, path: t.path[0]})]
      })
    }, Ds = function (e) {
      var t = e.txn, n = (e.role, e.address), a = ta(t, n), s = t.path[0].challengee, i = t.challenger, l = n === i,
        c = n === s, u = "poc_witnesses_valid" === a || "poc_witnesses_invalid" === a,
        d = "poc_receipts_v1" === t.type ? "hotspot" : "validator";
      return (0, r.jsxs)("div", {
        className: "w-full flex flex-col items-center justify-center space-y-px tracking-tight",
        children: [(0, r.jsxs)("div", {
          className: "bg-white w-full rounded-t-lg px-2 py-2 flex flex-row items-start justify-start",
          children: [(0, r.jsx)(ha, {
            txn: {
              type: "poc_receipts_v1",
              role: "challenger"
            }
          }), (0, r.jsxs)("div", {
            className: "ml-2 flex flex-col items-start justify-start",
            children: [(0, r.jsx)("span", {
              className: "text-xs font-sans font-light",
              children: "Challenger"
            }), l ? (0, r.jsxs)("span", {
              className: "-mt-0.5 md:-mt-1 text-sm md:text-base flex flex-row items-center justify-start text-black font-medium",
              children: [(0, r.jsx)(Hs, {className: "text-black w-4 h-auto mr-1 inline"}), bn()(n)]
            }) : (0, r.jsx)(o.Link, {
              to: "/".concat(d, "s/").concat(i),
              className: "-mt-1 flex flex-row items-center justify-start text-sm md:text-base font-sans font-medium text-black hover:text-navy-400 outline-none border border-solid border-transparent focus:border-navy-400",
              children: bn()(i)
            })]
          })]
        }), (0, r.jsx)("div", {
          className: "w-full flex flex-row items-stretch justify-center space-x-px h-full",
          children: (0, r.jsxs)("div", {
            className: "bg-white px-2 py-2 w-full flex flex-row items-start justify-start",
            children: [(0, r.jsx)(ha, {
              txn: {
                type: "poc_receipts_v1",
                role: "challengee"
              }
            }), (0, r.jsxs)("div", {
              className: "ml-2 flex flex-col items-start justify-start",
              children: [(0, r.jsxs)("span", {
                className: "flex flex-col items-start justify-start",
                children: [(0, r.jsx)("span", {
                  className: "text-xs font-sans font-light",
                  children: "Beaconer"
                }), c ? (0, r.jsxs)("span", {
                  className: "-mt-0.5 md:-mt-1 text-sm md:text-base flex flex-row items-center justify-start text-black font-medium",
                  children: [(0, r.jsx)(Hs, {className: "text-black w-4 h-auto mr-1 inline"}), bn()(n)]
                }) : (0, r.jsx)(o.Link, {
                  to: "/hotspots/".concat(s),
                  className: "-mt-0.5 md:-mt-1 flex flex-row items-center justify-start text-sm md:text-base font-sans font-medium text-black hover:text-navy-400 outline-none border border-solid border-transparent focus:border-navy-400",
                  children: bn()(s)
                })]
              }), (0, r.jsx)("span", {
                className: "text-xs md:text-sm font-sans font-light text-black ml-0.5 whitespace-nowrap",
                children: (0, r.jsx)(de, {geocode: t.path[0].geocode, condensedView: !0})
              })]
            })]
          })
        }), (0, r.jsx)("div", {
          className: "bg-white px-2 py-2 w-full flex flex-col items-start justify-start", children: (0, r.jsxs)("div", {
            className: "flex flex-row items-start justify-start",
            children: [(0, r.jsx)(ha, {txn: {type: "poc_receipts_v1", role: "witness"}}), (0, r.jsxs)("div", {
              className: "ml-2 flex flex-col items-start justify-start", children: [(0, r.jsxs)("span", {
                className: "flex flex-col items-start justify-start",
                children: [(0, r.jsxs)("span", {
                  className: "flex flex-row items-center justify-start",
                  children: [(0, r.jsx)("span", {
                    className: "text-xs font-sans font-light",
                    children: "Witnesses"
                  }), (0, r.jsxs)("div", {
                    className: "flex flex-row items-center justify-start space-x-1 ml-2",
                    children: [(0, r.jsxs)("div", {
                      className: "flex items-center justify-center",
                      children: [(0, r.jsx)("img", {
                        src: "/images/witness-yellow-mini.svg",
                        className: "w-3 h-auto",
                        alt: ""
                      }), (0, r.jsx)("span", {
                        className: "text-xs font-sans font-light text-black ml-0.5",
                        children: null === t || void 0 === t ? void 0 : t.numberOfValidWitnesses
                      })]
                    }), (0, r.jsxs)("div", {
                      className: "flex items-center justify-center",
                      children: [(0, r.jsx)("img", {
                        src: "/images/witness-gray.svg",
                        className: "w-3 h-auto",
                        alt: ""
                      }), (0, r.jsx)("span", {
                        className: "text-xs font-sans font-light text-black ml-0.5",
                        children: null === t || void 0 === t ? void 0 : t.numberOfInvalidWitnesses
                      })]
                    })]
                  })]
                }), u ? (0, r.jsxs)("span", {
                  className: "-mt-0.5 md:-mt-1 flex flex-row space-x-1 align-center justify-start text-sm md:text-base font-sans font-medium",
                  children: [(0, r.jsxs)("span", {
                    className: "flex flex-row items-center justify-start text-black",
                    children: [(0, r.jsx)(Hs, {className: "text-black w-4 h-auto mr-1 inline"}), bn()(n)]
                  }), t.path[0].witnesses.length > 1 && (0, r.jsx)("span", {
                    className: "text-gray-550",
                    children: "& ".concat(t.path[0].witnesses.length - 1, " other").concat(t.path[0].witnesses.length - 1 === 1 ? "" : "s")
                  })]
                }) : (0, r.jsxs)("span", {
                  className: "-mt-0.5 md:-mt-1 text-sm md:text-base font-sans font-medium text-gray-550",
                  children: [t.path[0].witnesses.length, " hotspots"]
                })]
              }), (0, r.jsx)(Fs, {txn: t, role: a, address: n, isWitness: u})]
            })]
          })
        })]
      })
    }, Zs = function (e) {
      var t = e.txn;
      return (0, r.jsx)("div", {
        className: "flex flex-col items-start w-full space-y-1 my-0.5",
        children: t.stateChannel.summaries.map((function (e, t) {
          return (0, r.jsx)("span", {
            className: "mr-1 w-full px-2 py-1 flex rounded-md justify-between items-center",
            children: (0, r.jsxs)("div", {
              className: "flex items-start justify-between flex-row w-full",
              children: [(0, r.jsxs)("span", {
                className: "text-black font-sans text-sm whitespace-nowrap",
                children: [e.numPackets, " packets"]
              }), (0, r.jsxs)("span", {
                className: "text-black font-sans text-sm flex flex-row items-center justify-start space-x-2",
                children: [(0, r.jsx)("img", {
                  src: "/images/dc.svg",
                  alt: ""
                }), (0, r.jsxs)("span", {
                  className: "text-sm text-black font-sans font-light",
                  children: [e.numDcs, " DC"]
                })]
              }), (0, r.jsx)("span", {
                className: "text-black font-sans text-sm whitespace-nowrap",
                children: Wa(24 * e.numDcs)
              })]
            })
          }, t)
        }))
      })
    }, Rs = {
      poc_witnesses: "Witness",
      poc_challengers: "Challenger",
      poc_challengees: "Beacon",
      data_credits: "Data",
      consensus: "Consensus"
    }, Gs = {
      poc_witnesses: "witness",
      poc_challengers: "challenger",
      poc_challengees: "challengee",
      data_credits: "data",
      consensus: "consensus"
    }, Vs = function (e) {
      var t = e.txn, n = e.role;
      return (0, r.jsxs)("div", {
        className: "flex flex-col items-start w-full space-y-1 my-0.5 border border-solid border-gray-300 rounded-md",
        children: [t.rewards.map((function (e, t, a) {
          var s = a.length;
          return (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsxs)("span", {
              className: "mr-1 w-full px-2 pt-2 pb-1 flex rounded-md justify-between items-center",
              children: [(0, r.jsxs)("div", {
                className: "flex items-start justify-start flex-col",
                children: [(0, r.jsx)("span", {
                  className: "text-black font-sans text-sm",
                  children: "+".concat(e.amount.toString(5))
                }), "reward_gateway" !== n && (0, r.jsx)("span", {
                  className: "text-black font-sans text-sm font-thin",
                  children: (null === e || void 0 === e ? void 0 : e.gateway) && bn()(e.gateway)
                })]
              }), (0, r.jsx)(ve, {title: Rs[e.type] || e.type, tooltip: e.type, color: Gs[e.type]}, e.type)]
            }, t), t !== s - 1 && (0, r.jsx)("div", {className: "h-px bg-gray-300 w-full"})]
          })
        })), (0, r.jsxs)("div", {
          className: "bg-gray-200 flex flex-row items-center justify-between w-full border-t border-solid border-gray-500 px-1 py-2 rounded-b-md",
          children: [(0, r.jsx)("span", {
            className: "text-black font-sans text-sm px-1 font-bold",
            children: "+".concat(t.totalAmount.toString(5))
          }), (0, r.jsx)("span", {className: "text-xs text-gray-800 px-4", children: "Total"})]
        })]
      })
    };

    function Ws(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Us = function (e) {
      var t = e.address, n = e.title;
      return (0, r.jsx)(At, {
        title: n,
        value: (0, r.jsxs)("div", {
          className: "flex items-center justify-start",
          children: [(0, r.jsx)(Ea, {address: t}), (0, r.jsxs)("span", {
            className: "pl-1",
            children: [(0, r.jsx)(he, {
              address: t,
              truncate: 7,
              showSecondHalf: !1
            }), (0, r.jsx)("span", {className: "text-gray-600", children: "(this account)"})]
          })]
        })
      })
    }, zs = function (e) {
      var t, n = e.txn, s = (e.role, e.address), i = n.seller === s, o = (0, a.useState)(), l = o[0], c = o[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, (0, vn.Fc)(n.gateway);
            case 2:
              t = e.sent, c(t);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            Ws(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Ws(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), []), (0, r.jsxs)("div", {
        className: "w-full flex flex-col items-stretch justify-center space-y-1 tracking-tight",
        children: [l ? (0, r.jsx)(yn, {title: "Hotspot", hotspot: l}) : (0, r.jsx)(At, {
          title: "Hotspot",
          value: bn()(n.gateway),
          span: 2,
          change: (0, r.jsx)(me, {className: "w-1/3"})
        }), i ? (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)(Us, {
            address: n.seller,
            title: "Previous Owner"
          }), (0, r.jsx)(Fa, {address: n.buyer, title: "New Owner"})]
        }) : (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)(Fa, {
            address: n.seller,
            title: "Previous Owner"
          }), (0, r.jsx)(Us, {address: n.buyer, title: "New Owner"})]
        }), (0, r.jsx)(At, {title: "Amount", value: n.amountToSeller.toString(2)})]
      })
    };

    function Ks(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var qs = function (e) {
      var t = e.address, n = e.title;
      return (0, r.jsx)(At, {
        title: n,
        value: (0, r.jsxs)("div", {
          className: "flex items-center justify-start",
          children: [(0, r.jsx)(Ea, {address: t}), (0, r.jsxs)("span", {
            className: "pl-1",
            children: [(0, r.jsx)(he, {
              address: t,
              truncate: 7,
              showSecondHalf: !1
            }), (0, r.jsx)("span", {className: "text-gray-600", children: "(this account)"})]
          })]
        })
      })
    }, $s = function (e) {
      var t, n = e.txn, s = (e.role, e.address), i = n.owner === s, o = (0, a.useState)(), l = o[0], c = o[1];
      return (0, Qt.r5)((t = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, (0, vn.Fc)(n.gateway);
            case 2:
              t = e.sent, c(t);
            case 4:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var e = this, n = arguments;
        return new Promise((function (r, a) {
          var s = t.apply(e, n);

          function i(e) {
            Ks(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Ks(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), [n.gateway]), (0, r.jsxs)("div", {
        className: "w-full flex flex-col items-stretch justify-center space-y-1 tracking-tight",
        children: [l ? (0, r.jsx)(yn, {title: "Hotspot", hotspot: l}) : (0, r.jsx)(At, {
          title: "Hotspot",
          value: bn()(n.gateway),
          span: 2,
          change: (0, r.jsx)(me, {className: "w-1/3"})
        }), i ? (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)(qs, {
            address: n.owner,
            title: "Previous Owner"
          }), (0, r.jsx)(Fa, {address: n.newOwner, title: "New Owner"})]
        }) : (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsx)(Fa, {
            address: n.owner,
            title: "Previous Owner"
          }), (0, r.jsx)(qs, {address: n.newOwner, title: "New Owner"})]
        })]
      })
    };

    function Js(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function Ys(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function Xs(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return Js(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return Js(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var Qs = function (e) {
      var t = e.txn, n = e.role, a = e.address, s = e.linkTo, i = e.linkClickHandler;
      if (!t) return (0, r.jsx)("div", {
        className: "px-6",
        children: (0, r.jsx)("div", {
          className: "bg-white w-full rounded-lg px-2 py-2",
          children: (0, r.jsxs)("div", {className: "space-y-2", children: [(0, r.jsx)(me, {}), (0, r.jsx)(me, {})]})
        })
      });
      var l = function (e) {
        switch (e.type) {
          case"rewards_v1":
          case"rewards_v2":
          case"rewards_v3":
            return Vs;
          case"state_channel_close_v1":
            return Zs;
          case"poc_receipts_v1":
          case"poc_receipts_v2":
            return Ds;
          case"transfer_hotspot_v1":
            return zs;
          case"transfer_hotspot_v2":
            return $s;
          default:
            return null
        }
      }(t), c = function (e) {
        return !(null === e || void 0 === e ? void 0 : e.type.startsWith("poc_receipts"))
      }(t);
      return (0, r.jsxs)("div", {
        className: "px-6",
        children: [(0, r.jsx)("div", {
          className: ce()({
            "bg-white w-full rounded-t-lg px-2 py-2": c,
            "rounded-b-lg": null === t || void 0 === t ? void 0 : t.type.startsWith("rewards")
          }),
          children: l ? (0, r.jsx)(l, {txn: t, role: n, address: a}) : (0, r.jsx)(ws, {
            txn: t,
            isLoading: !t,
            inline: !0
          })
        }), t && !(null === t || void 0 === t ? void 0 : t.type.startsWith("rewards")) && (0, r.jsxs)(o.Link, {
          to: s,
          onClick: i,
          className: ce()("w-full bg-white hover:bg-gray-350 transition-all duration-200 cursor-pointer rounded-b-lg mt-px flex items-center justify-center"),
          children: [(0, r.jsx)("p", {
            className: "text-gray-700 font-sans font-medium text-sm p-2 m-0",
            children: "View Transaction Details"
          }), (0, r.jsx)(ht, {className: "h-auto text-gray-700 transition-all duration-200 w-4 transform rotate-90"})]
        })]
      })
    }, ei = function (e) {
      var t = e.address, n = e.context, s = e.txn, i = e.title, o = e.linkTo, l = e.highlightColor, c = Xs(We(), 2),
        u = c[0], d = c[1], m = (0, Se.Z)(), h = m.selectTxn, p = m.clearSelectedTxn, x = (0, ee.Z)(),
        v = x.selectHotspot, g = x.clearSelectedHotspot, y = (0, a.useState)(), j = y[0], w = y[1],
        b = (0, a.useState)(!1), k = b[0], N = b[1], S = (0, a.useState)(!1), C = S[0], L = S[1], T = function () {
          var e, t = (e = f().mark((function e(t, n) {
            var r;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  return N(!0), e.next = 3, (0, gr.Pr)(t.hash, (null === t || void 0 === t ? void 0 : t.type.startsWith("rewards")) || "state_channel_close_v1" === (null === t || void 0 === t ? void 0 : t.type) ? {actor: n} : {});
                case 3:
                  r = e.sent, w(r), N(!1);
                case 6:
                case"end":
                  return e.stop()
              }
            }), e)
          })), function () {
            var t = this, n = arguments;
            return new Promise((function (r, a) {
              var s = e.apply(t, n);

              function i(e) {
                Ys(s, r, a, i, o, "next", e)
              }

              function o(e) {
                Ys(s, r, a, i, o, "throw", e)
              }

              i(void 0)
            }))
          });
          return function (e, n) {
            return t.apply(this, arguments)
          }
        }();
      (0, a.useEffect)((function () {
        var e;
        return ((e = s.type).startsWith("rewards") || e.startsWith("poc_receipts") || e.startsWith("payment") || e.startsWith("state_channel_close") || e.startsWith("validator_heartbeat") || e.startsWith("transfer_hotspot")) && (L(!0), T(s, t)), function () {
          L(!1), w(null)
        }
      }), [t, s]);
      var P = (0, a.useCallback)((function () {
        u ? (p(), "hotspot" === n && v(t)) : (s.type.startsWith("rewards") || h(s.hash), C || T(s, t)), d()
      }), [t, p, n, u, C, v, h, d, s]);
      return (0, a.useEffect)((function () {
        return function () {
          p()
        }
      }), [p]), (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsx)("div", {
          className: ce()("bg-white hover:bg-bluegray-50 focus:bg-bluegray-50 cursor-pointer transition-all duration-75 relative flex border-solid border-bluegray-300 border-t-0 h-[60px]"),
          onClick: P,
          children: (0, r.jsx)("div", {
            className: "w-full flex items-stretch justify-center",
            children: (0, r.jsxs)("div", {
              className: "w-full flex px-4 py-2 space-x-2 items-center",
              children: [(0, r.jsx)(ha, {
                txn: s,
                highlightColor: l
              }), (0, r.jsxs)("div", {
                className: "w-full flex flex-row",
                children: [(0, r.jsxs)("div", {
                  className: "w-full flex flex-col justify-between",
                  children: [(0, r.jsx)("div", {
                    className: "text-sm md:text-base font-medium text-darkgray-800 font-sans",
                    children: i
                  }), C && !u && (0, r.jsx)(Os, {txn: j, detailsLoading: k, address: t, role: s.role})]
                }), (0, r.jsx)(pa, {
                  txn: s,
                  expanded: u
                }), (0, r.jsx)("div", {
                  className: "flex items-center justify-center",
                  children: (0, r.jsx)(xa, {
                    className: ce()("h-auto text-gray-550 transition-all duration-200 w-3.5 transform", {
                      "rotate-0": u,
                      "rotate-180": !u
                    })
                  })
                })]
              })]
            })
          })
        }), (0, r.jsx)("div", {
          className: ce()("w-full flex flex-col justify-between bg-bluegray-50 transition-all duration-200", {
            "py-0 opacity-0": !u,
            "py-4 opacity-100": u
          }), children: u && (0, r.jsx)(Qs, {txn: j, role: s.role, address: t, linkClickHandler: g, linkTo: o})
        }), (0, r.jsx)("div", {className: "w-full border-solid border-b border-bluegray-300"})]
      })
    }, ti = function (e) {
      var t = e.title, n = e.description, s = e.address, i = e.context, o = e.transactions, l = e.isLoading,
        c = void 0 === l || l, u = e.fetchMore, d = e.isLoadingMore, f = e.hasMore,
        m = (0, a.useCallback)((function (e) {
          console.log("selected txn", e)
        }), []), h = (0, a.useCallback)((function (e) {
          return e.hash
        }), []), p = (0, a.useCallback)((function (e) {
          return !function (e) {
            return "rewards_v1" === e.type || "rewards_v2" === e.type || "rewards_v3" === e.type || "poc_receipts_v1" === e.type || "poc_receipts_v2" === e.type
          }(e) && "/txns/".concat(e.hash)
        }), []), x = (0, a.useCallback)((function (e) {
          switch (e.type) {
            case"poc_receipts_v1":
            case"poc_receipts_v2":
              return Yr(ea(e.role), "hotspot");
            case"transfer_validator_stake_v1":
              return (0, r.jsx)("span", {children: "Stake Transfer"});
            case"payment_v1":
            case"payment_v2":
              return (0, r.jsx)("span", {children: "payer" === e.role ? "Sent HNT" : "Received HNT"});
            default:
              return Yr(e.type, i)
          }
        }), [i]), v = (0, a.useCallback)((function (e) {
          return (0, r.jsx)(ei, {
            txn: e,
            address: s,
            context: i,
            title: x(e),
            linkTo: "/txns/".concat(e.hash),
            highlightColor: "poc_receipts_v1" === e.type ? Xr(ea(e.role)) : Xr(e.type)
          })
        }), [s, i, x]);
      return (0, r.jsx)(In, {
        isActivityList: !0,
        defaultBaseItem: !1,
        listHeaderTitle: t,
        listHeaderDescription: n,
        items: o,
        keyExtractor: h,
        linkExtractor: p,
        expandableItem: function () {
          return !0
        },
        onSelectItem: m,
        isLoading: c,
        renderItem: v,
        blankTitle: "No activity",
        fetchMore: u,
        isLoadingMore: d,
        hasMore: f,
        itemPadding: !1
      })
    };

    function ni(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    var ri = function (e) {
      var t = e.title, n = e.active, s = void 0 !== n && n, i = e.onClick, o = e.type, l = e.disabled,
        c = (0, a.useCallback)((function () {
          i(t)
        }), [i, t]);
      return (0, r.jsx)("span", function (e) {
        for (var t = 1; t < arguments.length; t++) {
          var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
          "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
            return Object.getOwnPropertyDescriptor(n, e).enumerable
          })))), r.forEach((function (t) {
            ni(e, t, n[t])
          }))
        }
        return e
      }({}, l ? {} : {onClick: c}, {
        className: ce()("py-1 px-2.5 mr-0 md:mr-1 flex font-medium text-sm md:text-base cursor-pointer whitespace-nowrap transition-all transform duration-200", {
          "text-gray-700": !s,
          "text-white rounded-full": s,
          "cursor-wait ": l
        }), style: s ? {backgroundColor: Xr(o)} : {}, children: t
      }))
    }, ai = function (e) {
      var t = e.navItems, n = e.activeItem, s = e.onClick, i = e.disabled, o = (0, a.useRef)(null), l = Et(o),
        c = l.autoScroll, u = l.isScrollable, d = l.isScrolledToStart, f = l.isScrolledToEnd,
        m = l.updateScrollIndicators;
      return (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsxs)("div", {
          className: "flex px-2 md:px-4 py-2 md:py-3 bg-white overflow-x-scroll no-scrollbar border-b border-gray-400 border-solid",
          ref: o,
          onScroll: m,
          children: [t.map((function (e) {
            return (0, r.jsx)(ri, {title: e.key, type: e.value[0], active: e.key === n, onClick: s, disabled: i}, e.key)
          })), (0, r.jsx)("span", {className: "pr-4"})]
        }), (0, r.jsx)(Ft, {
          direction: "right",
          wrapperClasses: "pb-1",
          onClick: c,
          shown: u && !f
        }), (0, r.jsx)(Ft, {
          direction: "left", wrapperClasses: "pb-1", onClick: function () {
            return c({direction: "left"})
          }, shown: u && !d
        })]
      })
    };

    function si(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function ii(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return si(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return si(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var oi = {
      hotspot: {
        "All Activity": [],
        Beacons: ["poc_receipts_v1", "poc_receipts_v2"],
        Data: ["state_channel_close_v1"],
        Rewards: ["rewards_v1", "rewards_v2", "rewards_v3"]
      },
      account: {
        "All Activity": [],
        Payments: ["payment_v1", "payment_v2"],
        Stakes: ["stake_validator_v1", "unstake_validator_v1", "transfer_validator_stake_v1"],
        "Hotspot Transfers": ["transfer_hotspot_v1", "transfer_hotspot_v2"],
        "Token Burns": ["token_burn_v1"],
        Rewards: ["rewards_v1", "rewards_v2", "rewards_v3"]
      },
      validator: {
        "All Activity": [],
        Heartbeats: ["validator_heartbeat_v1"],
        Rewards: ["rewards_v1", "rewards_v2", "rewards_v3"],
        Stakes: ["stake_validator_v1", "unstake_validator_v1", "transfer_validator_stake_v1"]
      }
    }, li = {hotspot: "All Activity", validator: "All Activity", account: "All Activity"}, ci = function (e) {
      var t = e.context, n = e.address, s = (0, a.useRef)(), i = (0, a.useState)(0), l = i[0], u = i[1],
        d = (0, a.useState)(!0), m = d[0], h = d[1], p = (0, a.useState)(li[t]), x = p[0], v = p[1], g = oi[t],
        y = function (e, t) {
          var n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : [],
            r = arguments.length > 3 && void 0 !== arguments[3] ? arguments[3] : 20, s = (0, a.useState)(), i = s[0],
            o = s[1], l = (0, a.useState)([]), c = l[0], u = l[1], d = (0, a.useState)(!0), m = d[0], h = d[1],
            p = (0, a.useState)(!1), x = p[0], v = p[1], g = (0, a.useState)(!0), y = g[0], j = g[1];
          (0, Qt.r5)(da(f().mark((function r() {
            var a, s;
            return f().wrap((function (r) {
              for (; ;) switch (r.prev = r.next) {
                case 0:
                  return a = ma(t, e), r.next = 3, a.roles.list({filterTypes: n});
                case 3:
                  s = r.sent, o(s);
                case 5:
                case"end":
                  return r.stop()
              }
            }), r)
          }))), [t, n, e]), (0, Qt.r5)(da(f().mark((function e() {
            var t;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  if (i) {
                    e.next = 2;
                    break
                  }
                  return e.abrupt("return");
                case 2:
                  return v(!0), e.next = 5, i.take(r);
                case 5:
                  t = e.sent, u(t), v(!1), h(!1), t.length < r && j(!1);
                case 10:
                case"end":
                  return e.stop()
              }
            }), e)
          }))), [i, r]), (0, a.useEffect)((function () {
            h(!0), j(!0), v(!0)
          }), [n]);
          var w = (0, a.useCallback)(da(f().mark((function e() {
            var t;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  return e.next = 2, i.take(r);
                case 2:
                  t = e.sent, u(fa(c).concat(fa(t)));
                case 4:
                case"end":
                  return e.stop()
              }
            }), e)
          }))), [i, r, c]);
          return {transactions: c, fetchMore: w, isLoadingInitial: m, isLoadingMore: x, hasMore: y}
        }(t, n, g[x]), j = y.transactions, w = y.fetchMore, b = y.isLoadingInitial, k = y.isLoadingMore, N = y.hasMore,
        S = (0, a.useCallback)((function () {
          return (0, c.debounce)((function (e, t) {
            h(t > e), u(e)
          }), 100, {leading: !0, trailing: !0})
        }), []), C = (0, a.useCallback)((function (e) {
          var t = e.target.scrollTop;
          S(t, l)
        }), [l, S]);
      (0, a.useEffect)((function () {
        var e = s.current;
        return e.addEventListener("scroll", C), function () {
          return e.removeEventListener("scroll", C)
        }
      }), [C]);
      var L = (0, a.useCallback)((function (e) {
        v(e), s.current.scrollTo(0, 0)
      }), []);
      return (0, r.jsxs)("div", {
        ref: s,
        className: ce()("no-scrollbar", {"overflow-y-scroll": !b, "overflow-y-hidden": b}),
        children: [(0, r.jsx)("div", {
          className: ce()("sticky top-0 transform-gpu transition-transform duration-300 ease-in-out z-20", {"-translate-y-16": !m}),
          children: (0, r.jsx)(ai, {
            navItems: Object.entries(g).map((function (e) {
              var t = ii(e, 2);
              return {key: t[0], value: t[1]}
            })), activeItem: x, disabled: b || k, onClick: L
          })
        }), (0, r.jsx)("div", {
          className: "grid grid-flow-row grid-cols-1",
          children: (0, r.jsx)(ti, {
            title: "".concat((0, c.upperFirst)(t), " Activity (").concat(x, ")"),
            description: (0, r.jsxs)("div", {
              className: "flex flex-col space-y-2",
              children: [(0, r.jsxs)("div", {children: ["All transactions that this ", t, " has participated in, filtered by the currently selected filter (", x, ")."]}), (0, r.jsxs)("div", {
                children: ["If you want to create an export of this activity for taxes or record-keeping purposes, you can use one of the community-developed tools to do so. You can browse them all", " ", (0, r.jsx)(o.Link, {
                  className: "text-gray-800 font-bold hover:text-darkgray-800",
                  to: "/tools",
                  children: "here"
                }), "."]
              })]
            }),
            context: t,
            address: n,
            transactions: j,
            isLoading: b,
            isLoadingMore: k,
            fetchMore: w,
            hasMore: N
          })
        })]
      })
    }, ui = (0, a.memo)(ci), di = n(14361), fi = function (e) {
      var t = e.hotspot, n = e.witnessed, s = e.isLoading, i = void 0 === s || s, o = e.title, l = e.description,
        c = e.showCount, u = (0, ee.Z)().selectHotspot, d = (0, a.useCallback)((function (e) {
          u(e.address)
        }), [u]), f = (0, a.useCallback)((function (e) {
          return e.address
        }), []), m = (0, a.useCallback)((function (e) {
          return "/hotspots/".concat(e.address)
        }), []), h = (0, a.useCallback)((function (e) {
          return (0, r.jsxs)(r.Fragment, {children: [(0, r.jsx)(Nn, {status: e.status}), bn()(e.address)]})
        }), []), p = (0, a.useCallback)((function (e) {
          var t;
          return (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsx)(de, {
              geocode: e.geocode,
              shortenedLocationName: !0
            }), (0, r.jsxs)("span", {
              className: "flex items-center",
              children: [(0, r.jsx)(tr, {
                width: 10,
                height: 12,
                fillColor: (0, ae.w)(null === e || void 0 === e ? void 0 : e.rewardScale)
              }), (0, r.jsx)("span", {
                className: "ml-1",
                children: null === e || void 0 === e || null === (t = e.rewardScale) || void 0 === t ? void 0 : t.toFixed(2)
              })]
            })]
          })
        }), []), x = (0, a.useCallback)((function (e) {
          return (0, r.jsx)("span", {
            className: "whitespace-nowrap",
            children: (0, r.jsx)(fe.Z, {
              title: (0, r.jsx)(xn, {t: "tooltips.distance"}),
              placement: "left",
              children: ya(1e3 * (0, di.xm)((0, H.h3ToGeo)(e.locationHex)[1], (0, H.h3ToGeo)(e.locationHex)[0], (0, H.h3ToGeo)(t.locationHex)[1], (0, H.h3ToGeo)(t.locationHex)[0]))
            })
          })
        }), [t.locationHex]);
      return (0, r.jsx)(In, {
        items: n,
        listHeaderTitle: o,
        listHeaderDescription: l,
        listHeaderShowCount: c,
        keyExtractor: f,
        linkExtractor: m,
        onSelectItem: d,
        isLoading: i,
        renderTitle: h,
        renderSubtitle: p,
        renderDetails: x,
        blankTitle: "Not witnessed"
      })
    }, mi = function (e) {
      var t = e.hotspot, n = (0, Qt.r5)(vn.XL, [t.address]), a = n.result, s = n.loading;
      return (0, r.jsx)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !s,
          "overflow-y-hidden": s
        }),
        children: (0, r.jsx)(fi, {
          hotspot: t,
          witnessed: a || [],
          isLoading: s,
          title: "Witnessed",
          description: (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsxs)("div", {children: ["Hotspots on the Helium network whose beacons", " ", bn()(t.address), " has successfully witnessed. There are many reasons a Hotspot may not be a valid witness."]}), (0, r.jsxs)("div", {
              className: "pt-1.5",
              children: ["Learn more", " ", (0, r.jsx)("a", {
                className: "text-navy-400",
                href: "https://docs.helium.com/troubleshooting/understanding-witnesses/",
                rel: "noopener noreferrer",
                target: "_blank",
                children: "here"
              }), "."]
            })]
          }),
          showCount: !0
        })
      })
    }, hi = function (e) {
      var t = e.hotspots, n = e.isLoading, s = void 0 === n || n, i = e.title, o = e.description, l = e.showCount,
        c = (0, ee.Z)().selectHotspot, u = (0, a.useCallback)((function (e) {
          c(e.address)
        }), [c]), d = (0, a.useCallback)((function (e) {
          return e.address
        }), []), f = (0, a.useCallback)((function (e) {
          return "/hotspots/".concat(e.address)
        }), []), m = (0, a.useCallback)((function (e) {
          return (0, r.jsxs)(r.Fragment, {children: [(0, r.jsx)(Nn, {status: e.status}), bn()(e.address)]})
        }), []), h = (0, a.useCallback)((function (e) {
          var t;
          return (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsx)(de, {
              geocode: e.geocode,
              shortenedLocationName: !0
            }), (0, r.jsxs)("span", {
              className: "flex items-center",
              children: [(0, r.jsx)(tr, {
                width: 10,
                height: 12,
                fillColor: (0, ae.w)(null === e || void 0 === e ? void 0 : e.rewardScale)
              }), (0, r.jsx)("span", {
                className: "ml-1",
                children: null === e || void 0 === e || null === (t = e.rewardScale) || void 0 === t ? void 0 : t.toFixed(2)
              })]
            })]
          })
        }), []), p = (0, a.useCallback)((function (e) {
          return (0, r.jsx)(fe.Z, {
            title: (0, r.jsx)(xn, {t: "tooltips.distance"}),
            placement: "left",
            children: (0, r.jsx)("span", {className: "whitespace-nowrap", children: ya(e.distance)})
          })
        }), []);
      return (0, r.jsx)(In, {
        items: t,
        listHeaderTitle: i,
        listHeaderShowCount: l,
        listHeaderDescription: o,
        keyExtractor: d,
        linkExtractor: f,
        onSelectItem: u,
        isLoading: s,
        renderTitle: m,
        renderSubtitle: h,
        renderDetails: p,
        blankTitle: "No nearby Hotspots"
      })
    }, pi = function (e) {
      var t = e.hotspot,
        n = (0, Qt.r5)(vn.jt, [(0, H.h3ToGeo)(null === t || void 0 === t ? void 0 : t.locationHex)[0], (0, H.h3ToGeo)(null === t || void 0 === t ? void 0 : t.locationHex)[1], 5e3]),
        s = n.result, i = n.loading, o = (0, a.useMemo)((function () {
          return s ? s.filter((function (e) {
            return e.address !== t.address
          })) : []
        }), [null === t || void 0 === t ? void 0 : t.address, s]);
      return (0, r.jsx)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !i,
          "overflow-y-hidden": i
        }),
        children: (0, r.jsx)(hi, {
          hotspots: o || [],
          isLoading: i,
          title: "Nearby Hotspots",
          description: "Hotspots that are close enough that ".concat(t ? bn()(t.address) : "this Hotspot", " could witness them or have its beacons witnessed by them. The probability of Hotspots interacting with each other depends on antenna location, position, and elevation."),
          showCount: !0
        })
      })
    }, xi = function () {
      return (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(At, {
          span: 2,
          subtitle: "subtitle",
          isLoading: !0
        }), (0, r.jsx)(At, {span: 1, subtitle: "subtitle", isLoading: !0}), (0, r.jsx)(At, {
          span: 1,
          subtitle: "subtitle",
          isLoading: !0
        }), (0, r.jsx)(At, {span: 2, subtitle: "subtitle", isLoading: !0}), (0, r.jsx)(At, {
          span: 1,
          subtitle: "subtitle",
          isLoading: !0
        }), (0, r.jsx)(At, {span: 1, subtitle: "subtitle", isLoading: !0}), (0, r.jsx)(At, {
          span: 1,
          subtitle: "subtitle",
          isLoading: !0
        }), (0, r.jsx)(At, {span: 1, subtitle: "subtitle", isLoading: !0})]
      })
    }, vi = function (e) {
      var t = e.index, n = e.truncateAmount, a = void 0 === n ? 5 : n, s = e.truncate, i = void 0 === s || s,
        o = e.showSecondHalf, l = void 0 !== o && o;
      return (0, r.jsx)("span", {children: i ? "".concat(t.slice(0, a), "...").concat(l ? t.slice(-a) : "") : t})
    }, gi = function (e) {
      var t = e.className;
      return (0, r.jsx)("svg", {
        xmlns: "http://www.w3.org/2000/svg",
        className: ce()(t, {"h-6 w-6 text-black": !t}),
        fill: "none",
        viewBox: "0 0 24 24",
        stroke: "currentColor",
        children: (0, r.jsx)("path", {
          strokeLinecap: "round",
          strokeLinejoin: "round",
          strokeWidth: 2,
          d: "M18.364 18.364A9 9 0 005.636 5.636m12.728 12.728A9 9 0 015.636 5.636m12.728 12.728L5.636 5.636"
        })
      })
    };

    function yi(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function ji(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function wi(e) {
      return function (e) {
        if (Array.isArray(e)) return yi(e)
      }(e) || function (e) {
        if ("undefined" !== typeof Symbol && null != e[Symbol.iterator] || null != e["@@iterator"]) return Array.from(e)
      }(e) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return yi(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return yi(e, t)
      }(e) || function () {
        throw new TypeError("Invalid attempt to spread non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var bi = function (e) {
      var t = e.address, n = e.isLoading, s = e.hotspot, i = (0, ee.Z)().clearSelectedHotspot,
        o = A(null === s || void 0 === s ? void 0 : s.payer), l = o.maker, c = o.isLoading,
        u = (0, a.useMemo)((function () {
          return (0, ae.yV)(s)
        }), [s]);
      (0, a.useEffect)((function () {
        return function () {
          i()
        }
      }), [i]);
      var d = (0, a.useState)(!1), m = d[0], h = d[1];
      (0, a.useEffect)((function () {
        var e = function () {
          var e, n = (e = f().mark((function e() {
            var n;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  return e.next = 2, (0, vn.Nl)(t);
                case 2:
                  (null === (n = e.sent) || void 0 === n ? void 0 : n.length) > 0 ? h(!0) : h(!1);
                case 4:
                case"end":
                  return e.stop()
              }
            }), e)
          })), function () {
            var t = this, n = arguments;
            return new Promise((function (r, a) {
              var s = e.apply(t, n);

              function i(e) {
                ji(s, r, a, i, o, "next", e)
              }

              function o(e) {
                ji(s, r, a, i, o, "throw", e)
              }

              i(void 0)
            }))
          });
          return function () {
            return n.apply(this, arguments)
          }
        }();
        e()
      }), [t]);
      var p, x = (0, a.useCallback)((function (e) {
          return e ? [wi((0, ae.yV)(e) ? [] : [{
            iconPath: "/images/maker.svg",
            title: c ? (0, r.jsx)(me, {}) : (0, r.jsx)("span", {children: null === l || void 0 === l ? void 0 : l.name}),
            path: "/accounts/".concat(null === l || void 0 === l ? void 0 : l.address)
          }]).concat([{
            iconPath: "/images/gain.svg",
            title: (0, r.jsx)(Bn, {hotspot: e, icon: !1})
          }, {
            iconPath: "/images/elevation.svg",
            title: (0, r.jsx)(En, {hotspot: e, icon: !1})
          }]), [{
            iconPath: "/images/address-symbol.svg",
            title: (0, r.jsx)(he, {address: t, truncate: 7}),
            textToCopy: t
          }, {
            iconPath: "/images/account-green.svg",
            title: (0, r.jsxs)("span", {
              className: "flex items-center justify-start",
              children: [(0, r.jsx)(he, {
                address: e.owner,
                truncate: 7,
                showSecondHalf: !1
              }), (0, r.jsx)(Ea, {address: e.owner, className: "h-2.5 md:h-3.5 w-auto ml-0.5"})]
            }),
            path: "/accounts/".concat(e.owner)
          }]] : [[{iconPath: "/images/maker.svg", loading: !0, skeletonClasses: "w-8"}, {
            iconPath: "/images/gain.svg",
            loading: !0,
            skeletonClasses: "w-10"
          }, {
            iconPath: "/images/elevation.svg",
            loading: !0,
            skeletonClasses: "w-10"
          }], [{
            iconPath: "/images/address-symbol.svg",
            loading: !0,
            skeletonClasses: "w-20"
          }, {iconPath: "/images/account-green.svg", loading: !0, skeletonClasses: "w-20"}]]
        }), [t, null === l || void 0 === l ? void 0 : l.address, null === l || void 0 === l ? void 0 : l.name, c]),
        v = (0, a.useCallback)((function (e) {
          var t = bn()(e);
          return (0, r.jsxs)("div", {
            className: "flex flex-col items-start justify-start",
            children: [(0, r.jsx)("div", {
              className: "w-full items-center justify-between relative",
              children: t
            }), m && (0, r.jsx)(fe.Z, {
              title: "This Hotspot is on the denylist. Click to learn more.",
              placement: "right",
              children: (0, r.jsxs)("a", {
                href: "https://github.com/helium/denylist",
                target: "_blank",
                rel: "noopener noreferrer",
                className: "text-xs font-sans uppercase text-white font-black bg-red-400 hover:bg-red-500 rounded-md px-2 py-1 mt-1 flex items-center justify-center",
                children: [(0, r.jsx)(gi, {className: "text-white h-3 w-3 mr-1"}), "On Denylist"]
              })
            })]
          })
        }), [m]), g = "validator" === Pr().challengeIssuer;
      return (0, r.jsx)(pt, {
        title: v(t),
        metaTitle: "Hotspot ".concat(bn()(t)),
        subtitles: x(s),
        breadcrumbs: (p = s, p ? [{
          title: "Hotspots",
          path: "/hotspots/latest"
        }].concat(wi(p.location ? [{
          title: (0, r.jsx)(de, {geocode: p.geocode, condensedView: !0}),
          path: "/hotspots/cities/".concat(p.geocode.cityId)
        }, {
          title: (0, r.jsxs)("div", {
            className: "flex items-center justify-center",
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/location-hex.svg",
              className: "h-3.5 w-auto mr-0.5 md:mr-1"
            }), (0, r.jsx)(vi, {index: p.location})]
          }), path: "/hotspots/hex/".concat(p.location)
        }] : [])) : [{title: "Hotspots", path: "/hotspots"}]),
        children: (0, r.jsxs)(pn, {
          htmlTitleRoot: "".concat(bn()(t)),
          children: [(0, r.jsx)(hn, {
            title: "Statistics",
            children: n ? (0, r.jsx)(xi, {}) : (0, r.jsx)(la, {hotspot: s, isDataOnly: u, liteHotspotsActive: g})
          }, "statistics"), (0, r.jsx)(hn, {
            title: "Activity",
            path: "activity",
            children: n ? (0, r.jsx)(An, {}) : (0, r.jsx)(ui, {
              context: "hotspot",
              address: null === s || void 0 === s ? void 0 : s.address
            })
          }, "activity"), (0, r.jsx)(hn, {
            title: "Witnessed",
            path: "witnessed",
            hidden: u,
            children: n ? (0, r.jsx)(Cn, {}) : (0, r.jsx)(mi, {hotspot: s})
          }, "witnessed"), (0, r.jsx)(hn, {
            title: "Nearby",
            path: "nearby",
            hidden: u,
            children: n ? (0, r.jsx)(Cn, {}) : (0, r.jsx)(pi, {hotspot: s})
          }, "nearby")]
        })
      })
    }, ki = function () {
      var e = (0, i.UO)().address, t = (0, ee.Z)(), n = t.selectedHotspot, s = t.selectHotspot,
        o = t.clearSelectedHotspot;
      return (0, a.useEffect)((function () {
        n || s(e)
      }), [n, e, s]), (0, a.useEffect)((function () {
        return function () {
          o()
        }
      }), [o]), (0, r.jsx)(bi, {address: e, isLoading: !n, hotspot: n})
    }, Ni = function (e, t) {
      return "1" === e ? "#ccc" : t > 0 ? "#FFC769" : "#29D391"
    }, Si = function () {
      var e = (0, L.ZP)("/validators/versions").data, t = (0, a.useMemo)((function () {
        return !e
      }), [e]), n = (0, a.useMemo)((function () {
        return e ? (0, c.sum)(Object.values(e)) : 0
      }), [e]);
      return (0, r.jsxs)("div", {
        className: "bg-gray-200 p-3 rounded-lg col-span-2",
        children: [(0, r.jsx)("div", {
          className: "text-gray-600 text-sm whitespace-nowrap",
          children: "Validator Versions"
        }), (0, r.jsx)("div", {
          className: "h-6 w-full my-3 rounded-lg flex overflow-hidden",
          children: t ? (0, r.jsx)("div", {className: "animate-pulse bg-gray-400 w-full"}) : Object.keys(e).sort().reverse().map((function (t, a) {
            return (0, r.jsx)(fe.Z, {
              title: "".concat(Pa(t), " (").concat(e[t], ")"),
              children: (0, r.jsx)("div", {
                style: {
                  background: Ni(t, a),
                  width: (s = e[t], i = n, s / i * 100 + "%"),
                  marginRight: 1
                }
              }, t)
            });
            var s, i
          }))
        }), (0, r.jsx)("div", {
          children: t ? (0, r.jsx)("div", {className: "animate-pulse bg-gray-400 w-1/4 h-4 rounded-md"}) : (0, r.jsxs)("span", {
            className: "font-mono text-gray-800 text-sm",
            children: ["Latest Version:", " ", Pa((0, c.max)(Object.keys(e))) || " N/A"]
          })
        })]
      })
    };

    function Ci(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function Li(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            Ci(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Ci(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    var Ti = function (e) {
      var t = (0, Rt.ZP)("consensusGroups", Li(f().mark((function e() {
        var t, n;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.elections.list();
            case 2:
              return e.next = 4, e.sent.take(20);
            case 4:
              return t = e.sent, e.next = 7, m.ZP.validators.elected();
            case 7:
              return e.next = 9, e.sent.take(m.pA);
            case 9:
              return n = e.sent, e.abrupt("return", {recentElections: t, currentElection: n});
            case 11:
            case"end":
              return e.stop()
          }
        }), e)
      }))), {initialData: e, refreshInterval: 1e4}), n = t.data, r = t.error;
      return {consensusGroups: n, isLoading: !r && !n, isError: r}
    }, Pi = function () {
      var e = Li(f().mark((function e() {
        var t, n;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.validators.elected();
            case 2:
              return t = e.sent, e.next = 5, t.take(m.pA);
            case 5:
              return n = e.sent, e.abrupt("return", n);
            case 7:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function () {
        return e.apply(this, arguments)
      }
    }(), Ai = n(94533);

    function Mi(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    var _i = function () {
      var e, t = (0, L.ZP)("/metrics/blocks").data, n = (0, a.useState)(!0), s = n[0], i = n[1], o = (0, a.useState)(),
        l = o[0], u = o[1];
      return (0, a.useEffect)((function () {
        if (t) {
          i(!0);
          var e = null === t || void 0 === t ? void 0 : t.electionTimeDay;
          u(null === e || void 0 === e ? void 0 : e.map((function (e) {
            return function (e) {
              for (var t = 1; t < arguments.length; t++) {
                var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
                "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
                  return Object.getOwnPropertyDescriptor(n, e).enumerable
                })))), r.forEach((function (t) {
                  Mi(e, t, n[t])
                }))
              }
              return e
            }({}, e, {value: (0, c.round)(e.value / 60, 1)})
          }))), i(!1)
        }
      }), [t]), (0, r.jsx)(Tt, {
        title: "Election Time (24hr)",
        series: l,
        valueSuffix: " min",
        changeInitial: "second_last",
        changeSuffix: " min",
        isLoading: s,
        periodLabel: "".concat(null === t || void 0 === t || null === (e = t.electionTimeDay) || void 0 === e ? void 0 : e.length, " days")
      })
    }, Oi = function () {
      var e, t, n, a, s, i, o, l, u, d, f, m, h, p, x, v, g, y, j, w, b, k, N, S, C = Jt().stats,
        L = Ti().consensusGroups, T = Nr().height;
      return (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(At, {
          title: "Time since last election",
          value: (null === L || void 0 === L || null === (e = L.recentElections) || void 0 === e || null === (t = e[0]) || void 0 === t ? void 0 : t.time) ? (0, ra.Z)(new Date(1e3 * L.recentElections[0].time)) : (0, r.jsx)(me, {}),
          subtitle: "".concat((null === L || void 0 === L || null === (n = L.recentElections) || void 0 === n || null === (a = n[0]) || void 0 === a ? void 0 : a.time) ? (0, Gr.Z)(new Date(1e3 * L.recentElections[0].time), "h:mm aaaa MMM d") : (0, r.jsx)(me, {})),
          isLoading: !(null === L || void 0 === L || null === (s = L.recentElections) || void 0 === s || null === (i = s[0]) || void 0 === i ? void 0 : i.time)
        }), (0, r.jsx)(At, {
          title: "Blocks since last election",
          value: T - (null === L || void 0 === L || null === (o = L.recentElections) || void 0 === o || null === (l = o[0]) || void 0 === l ? void 0 : l.height),
          subtitle: "Current height: ".concat(null === T || void 0 === T ? void 0 : T.toLocaleString()),
          isLoading: !L || !T
        }), (0, r.jsx)(_i, {}), (0, r.jsx)(At, {
          title: "Election Time (1h)",
          value: (0, c.round)((null === C || void 0 === C || null === (u = C.electionTimes) || void 0 === u || null === (d = u.lastHour) || void 0 === d ? void 0 : d.avg) / 60, 1),
          valueSuffix: " min",
          subtitle: "".concat((0, c.round)((null === C || void 0 === C || null === (f = C.electionTimes) || void 0 === f || null === (m = f.lastHour) || void 0 === m ? void 0 : m.stddev) / 60), " min std dev"),
          isLoading: !C
        }), (0, r.jsx)(At, {
          title: "Election Time (24h)",
          value: (0, c.round)((null === C || void 0 === C || null === (h = C.electionTimes) || void 0 === h || null === (p = h.lastDay) || void 0 === p ? void 0 : p.avg) / 60, 1),
          valueSuffix: " min",
          subtitle: "".concat((0, c.round)((null === C || void 0 === C || null === (x = C.electionTimes) || void 0 === x || null === (v = x.lastDay) || void 0 === v ? void 0 : v.stddev) / 60), " min std dev"),
          isLoading: !C
        }), (0, r.jsx)(At, {
          title: "Election Time (7d)",
          value: (0, c.round)((null === C || void 0 === C || null === (g = C.electionTimes) || void 0 === g || null === (y = g.lastWeek) || void 0 === y ? void 0 : y.avg) / 60, 1),
          valueSuffix: " min",
          subtitle: "".concat((0, c.round)((null === C || void 0 === C || null === (j = C.electionTimes) || void 0 === j || null === (w = j.lastWeek) || void 0 === w ? void 0 : w.stddev) / 60), " min std dev"),
          isLoading: !C
        }), (0, r.jsx)(At, {
          title: "Election Time (30d)",
          value: (0, c.round)((null === C || void 0 === C || null === (b = C.electionTimes) || void 0 === b || null === (k = b.lastMonth) || void 0 === k ? void 0 : k.avg) / 60, 1),
          valueSuffix: " min",
          subtitle: "".concat((0, c.round)((null === C || void 0 === C || null === (N = C.electionTimes) || void 0 === N || null === (S = N.lastMonth) || void 0 === S ? void 0 : S.stddev) / 60), " min std dev"),
          isLoading: !C
        })]
      })
    }, Hi = function (e) {
      var t = e.address, n = e.recentGroups;
      if (!n || 0 === n.length) return null;
      var a = n.slice(0, 5).reverse();
      return (0, r.jsx)("span", {
        className: "flex space-x-1", children: a.map((function (e, n) {
          var s = e.members, i = e.height, o = s.includes(t);
          return (0, r.jsx)(fe.Z, {
            title: o ? "In consensus" : "Not in consensus",
            children: (0, r.jsx)("span", {
              className: "w-2.5 h-2.5 rounded-full",
              style: {background: o ? "#9d6aee" : "#ccc", opacity: n === a.length - 1 ? 1 : .6}
            })
          }, "ci-".concat(t, "-").concat(i))
        }))
      })
    }, Ii = function (e) {
      var t = function (e) {
        var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 1,
          n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : "day",
          r = "rewards/validators/".concat(e, "/sum/").concat(t, "/").concat(n), a = function (e, t, n) {
            return function () {
              return Qn(e, t, n)
            }
          }, s = (0, Rt.ZP)(r, a(e, t, n), {refreshInterval: 0, dedupingInterval: 6e5}), i = s.data, o = s.error;
        return {rewardsSum: i, isLoading: !o && void 0 === i, isError: o}
      }(e.validator.address, 30), n = t.rewardsSum;
      return t.isLoading ? (0, r.jsx)(me, {className: "w-1/4"}) : (0, r.jsx)(fe.Z, {
        title: "HNT earned (30 days)",
        children: (0, r.jsxs)("div", {
          className: "flex items-center space-x-1",
          children: [(0, r.jsx)("img", {
            alt: "",
            src: "/images/hnt.svg",
            className: "w-3"
          }), " ", (0, r.jsxs)("span", {children: [(0, Fn.NM)(n, 2), " HNT"]})]
        })
      })
    }, Bi = function (e) {
      var t = e.validators, n = e.recentGroups, s = e.title, i = e.description, o = e.fetchMore, l = e.hasMore,
        u = e.isLoading, d = e.isLoadingMore, f = e.showCount, m = e.count, h = (0, a.useCallback)((function (e) {
          return e.address
        }), []), p = (0, a.useCallback)((function (e) {
          return "/validators/".concat(e.address)
        }), []), x = (0, a.useCallback)((function (e) {
          return (0, r.jsxs)("div", {
            className: "flex items-center space-x-1",
            children: [(0, r.jsx)(Ma, {status: e.status}), (0, r.jsx)("span", {children: "".concat(bn()(e.address))})]
          })
        }), []), v = (0, a.useCallback)((function (e) {
          return (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsx)(Ii, {validator: e}), (0, r.jsx)(fe.Z, {
              title: "Penalty Score",
              children: (0, r.jsxs)("div", {
                className: "flex items-center space-x-1",
                children: [(0, r.jsx)("img", {
                  src: "/images/penalty.svg",
                  className: "w-3"
                }), " ", (0, r.jsx)("span", {children: (0, c.round)(e.penalty, 2)})]
              })
            })]
          })
        }), []), g = (0, a.useCallback)((function (e) {
          return (0, r.jsx)(Hi, {address: e.address, recentGroups: n})
        }), [n]), y = (0, a.useMemo)((function () {
          return s || (f ? "Validators" : null)
        }), [f, s]);
      return (0, r.jsx)(In, {
        items: t,
        fetchMore: o,
        isLoading: u,
        hasMore: l,
        isLoadingMore: d,
        listHeaderTitle: y,
        listHeaderShowCount: f,
        listHeaderCount: m,
        listHeaderDescription: i,
        keyExtractor: h,
        linkExtractor: p,
        renderTitle: x,
        renderSubtitle: v,
        renderDetails: g,
        blankTitle: "No validators"
      })
    }, Ei = function () {
      var e = function (e, t) {
          var n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 20, r = (0, a.useState)(), s = r[0],
            i = r[1], o = (0, a.useState)([]), l = o[0], c = o[1], u = (0, a.useState)(!0), d = u[0], h = u[1],
            p = (0, a.useState)(!1), x = p[0], v = p[1], g = (0, a.useState)(!0), y = g[0], j = g[1], w = function () {
              return e && t ? "account" === e ? m.ZP.account(t).validators.list() : void 0 : m.ZP.validators.list()
            };
          (0, Qt.r5)(nn(f().mark((function e() {
            var t;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  return e.next = 2, w();
                case 2:
                  t = e.sent, i(t);
                case 4:
                case"end":
                  return e.stop()
              }
            }), e)
          }))), []), (0, Qt.r5)(nn(f().mark((function e() {
            var t;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  if (s) {
                    e.next = 2;
                    break
                  }
                  return e.abrupt("return");
                case 2:
                  return v(!0), e.next = 5, s.take(n);
                case 5:
                  t = e.sent, c(t), v(!1), h(!1), t.length < n && j(!1);
                case 10:
                case"end":
                  return e.stop()
              }
            }), e)
          }))), [s]);
          var b = (0, a.useCallback)(nn(f().mark((function e() {
            var t;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  return e.next = 2, s.take(n);
                case 2:
                  t = e.sent, c(rn(l).concat(rn(t)));
                case 4:
                case"end":
                  return e.stop()
              }
            }), e)
          }))), [s, n, l]);
          return {validators: l, fetchMore: b, isLoadingInitial: d, isLoadingMore: x, hasMore: y}
        }(), t = e.validators, n = e.fetchMore, s = e.isLoadingInitial, i = e.isLoadingMore, o = e.hasMore,
        l = Ti().consensusGroups, c = (0, a.useMemo)((function () {
          return (null === l || void 0 === l ? void 0 : l.recentElections) || []
        }), [l]);
      return (0, r.jsx)(Dt, {
        span: 1,
        padding: !1,
        children: (0, r.jsx)(Bi, {
          validators: t,
          recentGroups: c,
          title: "All Validators",
          fetchMore: n,
          isLoading: s,
          isLoadingMore: i,
          hasMore: o
        })
      })
    }, Fi = function () {
      var e = Ti().consensusGroups, t = function (e) {
        var t = (0, Rt.ZP)("consensusGroup", Pi, {initialData: e, refreshInterval: 1e4}), n = t.data, r = t.error;
        return {consensusGroup: n, isLoading: !r && !n, isError: r}
      }().consensusGroup, n = (0, a.useMemo)((function () {
        return (null === e || void 0 === e ? void 0 : e.recentElections) || []
      }), [e]), s = (0, a.useMemo)((function () {
        return !e || !t
      }), [e, t]);
      return (0, r.jsx)(Dt, {
        span: 1,
        padding: !1,
        children: (0, r.jsx)(Bi, {
          validators: t || [],
          recentGroups: n || [],
          title: "Currently Elected Validators (".concat(null === t || void 0 === t ? void 0 : t.length, ")"),
          isLoading: s
        })
      })
    }, Di = function (e) {
      if (!e) return 0;
      var t = (0, c.clamp)((0, Ai.Z)(new Date("2021-08-01"), new Date), 0, 365);
      return (1e4 * t + 5e3 * (365 - t)) / e / 1e4
    }, Zi = function () {
      var e, t, n, a, s, i, o, l = (0, L.ZP)("/metrics/validators").data, c = Ti().consensusGroups, u = cn().stats,
        d = zt().market;
      return (0, r.jsx)(pt, {
        title: "Validators", metaTitle: "Validators", children: (0, r.jsxs)(pn, {
          basePath: "validators", htmlTitleRoot: "Validators", children: [(0, r.jsx)(hn, {
            title: "Statistics", children: (0, r.jsxs)(Dt, {
              children: [(0, r.jsx)(At, {
                title: "Staked Validators",
                value: null === u || void 0 === u || null === (e = u.staked) || void 0 === e || null === (t = e.count) || void 0 === t ? void 0 : t.toLocaleString(),
                isLoading: !u,
                linkTo: "/validators/all"
              }), (0, r.jsx)(At, {
                title: "Consensus Size",
                value: null === c || void 0 === c || null === (n = c.currentElection) || void 0 === n ? void 0 : n.length,
                isLoading: !c,
                linkTo: "/validators/consensus"
              }), (0, r.jsx)(At, {
                title: "% Online",
                value: R((null === u || void 0 === u ? void 0 : u.active) / (null === u || void 0 === u || null === (a = u.staked) || void 0 === a ? void 0 : a.count)),
                tooltip: (0, r.jsxs)("div", {children: [(0, r.jsxs)("div", {children: ["Active: ", null === u || void 0 === u ? void 0 : u.active]}), (0, r.jsxs)("div", {children: ["Staked: ", null === u || void 0 === u || null === (s = u.staked) || void 0 === s ? void 0 : s.count]})]}),
                isLoading: !u
              }), (0, r.jsx)(At, {
                title: "Estimated APR",
                value: R(Di(null === u || void 0 === u ? void 0 : u.active)),
                isLoading: !u,
                tooltip: "Annual percent return of validators that are staked and online. Note that unstaking tokens invokes a 250,000 block (~5 mo.) cooldown period where no returns will be earned before the staked tokens become liquid again. Earned rewards are immediately liquid."
              }), (0, r.jsx)(At, {
                title: "Total Staked (".concat("HNT", ")"),
                value: Z(null === u || void 0 === u || null === (i = u.staked) || void 0 === i ? void 0 : i.amount),
                change: (0, r.jsx)(Zt, {value: (null === d || void 0 === d ? void 0 : d.price) * (null === u || void 0 === u || null === (o = u.staked) || void 0 === o ? void 0 : o.amount)}),
                isLoading: !d || !u
              }), (0, r.jsx)(_t, {
                title: "% Supply Staked",
                series: null === l || void 0 === l ? void 0 : l.stakedPct,
                isLoading: !l,
                valueType: "percent",
                changeType: "percent"
              }), (0, r.jsx)(Si, {})]
            })
          }, "statistics"), (0, r.jsx)(hn, {
            title: "Elections",
            path: "elections",
            children: (0, r.jsx)(Oi, {})
          }, "elections"), (0, r.jsx)(hn, {
            title: "Consensus Group",
            path: "consensus",
            children: (0, r.jsx)(Fi, {})
          }, "consensus"), (0, r.jsx)(hn, {title: "All Validators", path: "all", children: (0, r.jsx)(Ei, {})}, "all")]
        })
      })
    }, Ri = function (e) {
      var t = e.blocks, n = e.isLoading, s = void 0 === n || n, i = e.fetchMore, o = e.isLoadingMore, c = e.hasMore,
        u = (0, a.useCallback)((function (e) {
        }), []), d = (0, a.useCallback)((function (e) {
          return e.hash
        }), []), f = (0, a.useCallback)((function (e) {
          return "/blocks/".concat(e.height)
        }), []), m = (0, a.useCallback)((function (e) {
          return (0, r.jsx)("p", {
            className: "text-black text-md font-semibold m-0 p-0",
            children: e.height.toLocaleString()
          })
        }), []), h = (0, a.useCallback)((function (e) {
          return (0, r.jsxs)("span", {
            className: "font-normal text-gray-600 flex flex-row items-center justify-between",
            children: [(0, r.jsxs)("span", {
              className: "flex items-center",
              children: [(0, r.jsx)(l.default, {
                src: "/images/clock.svg",
                width: 14,
                height: 14
              }), (0, r.jsx)(re(), {date: e.time, className: "tracking-tight text-gray-525 text-sm font-sans ml-1"})]
            }), (0, r.jsxs)("span", {
              className: "flex items-center justify-start ml-5",
              children: [(0, r.jsx)(l.default, {
                src: "/images/txn.svg",
                width: 14,
                height: 14
              }), (0, r.jsxs)("p", {
                className: "tracking-tight text-gray-525 text-sm font-sans m-0 ml-1",
                children: [e.transactionCount, " transactions"]
              })]
            })]
          })
        }), []), p = (0, a.useCallback)((function (e) {
          return (0, r.jsx)("span", {})
        }), []);
      return (0, r.jsx)(In, {
        items: t,
        keyExtractor: d,
        linkExtractor: f,
        onSelectItem: u,
        isLoading: s,
        renderTitle: m,
        renderSubtitle: h,
        renderDetails: p,
        blankTitle: "No blocks",
        fetchMore: i,
        isLoadingMore: o,
        hasMore: c
      })
    }, Gi = function () {
      var e = function () {
        var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : 20, t = (0, a.useState)(), n = t[0],
          r = t[1], s = (0, a.useState)([]), i = s[0], o = s[1], l = (0, a.useState)(!0), c = l[0], u = l[1],
          d = (0, a.useState)(!1), h = d[0], p = d[1], x = (0, a.useState)(!0), v = x[0], g = x[1];
        (0, Qt.r5)(wr(f().mark((function e() {
          var t;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                return e.next = 2, m.ZP.blocks.list();
              case 2:
                t = e.sent, r(t), u(!1);
              case 5:
              case"end":
                return e.stop()
            }
          }), e)
        }))), []), (0, Qt.r5)(wr(f().mark((function t() {
          var r;
          return f().wrap((function (t) {
            for (; ;) switch (t.prev = t.next) {
              case 0:
                if (n) {
                  t.next = 2;
                  break
                }
                return t.abrupt("return");
              case 2:
                return p(!0), t.next = 5, n.take(e);
              case 5:
                r = t.sent, o(r), p(!1), r.length < e && g(!1);
              case 9:
              case"end":
                return t.stop()
            }
          }), t)
        }))), [n]);
        var y = (0, a.useCallback)(wr(f().mark((function t() {
          var r;
          return f().wrap((function (t) {
            for (; ;) switch (t.prev = t.next) {
              case 0:
                return t.next = 2, n.take(e);
              case 2:
                r = t.sent, o(br(i).concat(br(r)));
              case 4:
              case"end":
                return t.stop()
            }
          }), t)
        }))), [n, e, i]);
        return {results: i, fetchMore: y, isLoadingInitial: c, isLoadingMore: h, hasMore: v}
      }(), t = e.results, n = e.fetchMore, s = e.isLoadingInitial, i = e.isLoadingMore, c = e.hasMore;
      return (0, r.jsxs)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !s,
          "overflow-y-hidden": s
        }),
        children: [!s && !i && (0, r.jsxs)(o.Link, {
          to: "/validators/consensus",
          className: ce()("hover:bg-gray-100", "bg-white", "relative", "flex", "flex-col", "border", "border-solid", "border-gray-500", "rounded-lg", "mt-3 mx-3 mb-4"),
          children: [(0, r.jsx)("div", {
            className: ce()("absolute", "top-0", "bottom-0", "w-12", "flex", "items-center", "justify-center", "bg-purple-700", "p-2", "rounded-tl-lg", "rounded-bl-lg"),
            children: (0, r.jsx)(l.default, {src: "/images/consensus_c.svg", width: 30, height: 30})
          }), (0, r.jsx)("div", {
            className: "pl-12 py-2",
            children: (0, r.jsxs)("div", {
              className: "pl-2 md:pl-3",
              children: [(0, r.jsx)("p", {
                className: "mb-1 text-md text-black text-md font-semibold leading-tight",
                children: (t[0].height + 1).toLocaleString()
              }), (0, r.jsx)("p", {
                className: "text-gray-650 font-medium m-0 leading-tight text-md",
                children: "In Consensus..."
              })]
            })
          })]
        }), (0, r.jsx)(Ri, {blocks: t, isLoading: s, isLoadingMore: i, fetchMore: n, hasMore: c})]
      })
    }, Vi = function () {
      var e, t = (0, L.ZP)("/metrics/blocks").data, n = (0, a.useState)(!0), s = n[0], i = n[1], o = (0, a.useState)(),
        l = o[0], u = o[1];
      return (0, a.useEffect)((function () {
        if (t) {
          var e;
          i(!0);
          var n = null === t || void 0 === t || null === (e = t.blockTimeDay) || void 0 === e ? void 0 : e.map((function (e) {
            return e.value = (0, c.round)(e.value, 2), e
          }));
          u(n), i(!1)
        }
      }), [t]), (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(Tt, {
          title: "Transaction Rate",
          series: null === t || void 0 === t ? void 0 : t.txnRate,
          isLoading: !t,
          periodLabel: "Last 100 Blocks"
        }), (0, r.jsx)(_t, {
          title: "Block Height",
          series: null === t || void 0 === t ? void 0 : t.height,
          linkTo: (null === t || void 0 === t || null === (e = t.height) || void 0 === e ? void 0 : e.length) ? "/blocks/".concat(t.height[t.height.length - 1].value) : "/blocks",
          isLoading: !t
        }), (0, r.jsx)(_t, {
          title: "Block Time (24hr)",
          series: l,
          valueSuffix: " sec",
          changeInitial: "second_last",
          changeSuffix: " sec",
          isLoading: s
        }), (0, r.jsx)(_i, {})]
      })
    }, Wi = function () {
      return (0, r.jsx)(pt, {
        title: (0, r.jsx)(xn, {t: "blocks.title"}),
        metaTitle: "Blocks",
        children: (0, r.jsxs)(pn, {
          basePath: "blocks",
          htmlTitleRoot: "Blocks",
          children: [(0, r.jsx)(hn, {
            title: "Statistics",
            children: (0, r.jsx)(Vi, {})
          }, "statistics"), (0, r.jsx)(hn, {
            title: "Elections",
            path: "elections",
            children: (0, r.jsx)(Oi, {})
          }, "elections"), (0, r.jsx)(hn, {
            title: "Latest Blocks",
            path: "latest",
            children: (0, r.jsx)(Gi, {})
          }, "latest")]
        })
      })
    }, Ui = n(81389), zi = function (e) {
      var t = e.classes;
      return (0, r.jsx)("svg", {
        xmlns: "http://www.w3.org/2000/svg",
        className: ce()(t),
        fill: "none",
        viewBox: "0 0 24 24",
        stroke: "currentColor",
        children: (0, r.jsx)("path", {
          strokeLinecap: "round",
          strokeLinejoin: "round",
          strokeWidth: 2,
          d: "M15 19l-7-7 7-7"
        })
      })
    }, Ki = function (e) {
      var t = e.classes;
      return (0, r.jsx)("svg", {
        xmlns: "http://www.w3.org/2000/svg",
        className: ce()(t),
        fill: "none",
        viewBox: "0 0 24 24",
        stroke: "currentColor",
        children: (0, r.jsx)("path", {
          strokeLinecap: "round",
          strokeLinejoin: "round",
          strokeWidth: 2,
          d: "M9 5l7 7-7 7"
        })
      })
    }, qi = function (e) {
      var t = e.linkPath, n = e.icon, a = e.classes;
      return (0, r.jsx)(o.Link, {
        className: ce()("bg-gray-800 shadow-md hover:bg-gray-650 transition-all duration-150 rounded-md h-7 w-7 flex items-center justify-center", a),
        to: t,
        children: n
      })
    }, $i = function (e) {
      var t = e.blockHash, n = e.blockHeight, a = e.blockTime,
        s = "La6PuV80Ps9qTP0339Pwm64q3_deMTkv6JOo1251EJI" === t || 1 === n ? 1564436673 : a;
      return (0, r.jsx)(re(), {date: s})
    }, Ji = function (e) {
      var t = e.highlightColor;
      return (0, r.jsx)("div", {className: ce()("h-full w-3"), style: {backgroundColor: t}})
    }, Yi = function (e) {
      var t = e.height, n = Cr(t), s = n.results, i = n.fetchMore, o = n.isLoadingInitial, l = n.isLoadingMore,
        c = n.hasMore, u = (0, a.useCallback)((function (e) {
          return e.hash
        }), []), d = (0, a.useCallback)((function (e) {
          return "/txns/".concat(e.hash)
        }), []), f = (0, a.useCallback)((function (e) {
          return (0, r.jsx)("span", {className: "text-xs text-gray-700 whitespace-nowrap", children: Yr(e.type)})
        }), []), m = (0, a.useCallback)((function (e) {
          switch (e.type) {
            case"poc_request_v1":
              return (0, r.jsx)("span", {
                className: "flex items-center",
                children: (0, r.jsx)("span", {
                  className: "flex items-center text-black font-sans font-medium",
                  children: bn()(e.challenger)
                })
              });
            case"poc_receipts_v1":
            case"poc_receipts_v2":
              return (0, r.jsx)("span", {
                className: "flex items-center",
                children: (0, r.jsx)("span", {
                  className: "flex items-center text-black font-sans font-medium",
                  children: bn()(e.path[0].challengee)
                })
              });
            case"add_gateway_v1":
            case"assert_location_v1":
            case"assert_location_v2":
              return (0, r.jsx)("span", {
                className: "flex items-center text-black font-sans font-medium",
                children: bn()(e.gateway)
              });
            case"payment_v1":
              return (0, r.jsx)("span", {
                className: "flex items-center whitespace-nowrap",
                children: (0, r.jsx)("span", {
                  className: "flex items-center text-black font-sans font-medium",
                  children: e.amount.toString(2)
                })
              });
            case"payment_v2":
              return (0, r.jsx)("span", {
                className: "flex items-center whitespace-nowrap",
                children: (0, r.jsx)("span", {
                  className: "flex items-center text-black font-sans font-medium",
                  children: e.totalAmount.toString(2)
                })
              });
            case"stake_validator_v1":
            case"validator_heartbeat_v1":
              return (0, r.jsx)("span", {
                className: "flex items-center",
                children: (0, r.jsx)("span", {
                  className: "flex items-center text-black font-sans font-medium",
                  children: bn()(e.address)
                })
              });
            default:
              return (0, r.jsx)("span", {className: "text-black", children: Yr(e.type)})
          }
        }), []), h = (0, a.useCallback)((function (e) {
          var t = (0, r.jsxs)("span", {
            className: "flex items-center space-x-1",
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/clock.svg",
              className: "h-3 w-auto"
            }), (0, r.jsx)($i, {blockTime: e.time, className: "tracking-tight"})]
          });
          switch (e.type) {
            case"poc_request_v1":
              var n = e.challengerOwner ? e.challengerOwner : e.owner;
              return (0, r.jsx)("div", {
                className: "flex items-center justify-end text-gray-600",
                children: n ? (0, r.jsxs)(r.Fragment, {
                  children: [(0, r.jsx)(Ea, {
                    size: 12,
                    address: n
                  }), (0, r.jsx)("span", {
                    className: "pl-1 ",
                    children: (0, r.jsx)(he, {clickable: !1, address: n, truncate: 4, mono: !0})
                  })]
                }) : t
              });
            case"add_gateway_v1":
              return (0, r.jsxs)("div", {
                className: "flex items-center justify-end text-gray-600",
                children: [(0, r.jsx)(Ea, {size: 12, address: e.owner}), (0, r.jsx)("span", {
                  className: "pl-1 ",
                  children: (0, r.jsx)(he, {clickable: !1, address: e.owner, truncate: 4, mono: !0})
                })]
              });
            case"poc_receipts_v1":
            case"poc_receipts_v2":
              return (0, r.jsxs)("span", {
                className: "flex items-center",
                children: [(0, r.jsx)("img", {
                  alt: "",
                  src: "/images/challenger-icon.svg",
                  className: "h-3 w-auto"
                }), (0, r.jsx)("span", {
                  className: "ml-1.5 whitespace-nowrap text-sm font-sans",
                  children: bn()(e.challenger)
                }), (0, r.jsx)("span", {
                  className: "ml-3 flex flex-row items-center justify-start",
                  children: (0, r.jsxs)("div", {
                    className: "flex items-center space-x-2",
                    children: [(0, r.jsxs)("div", {
                      className: "flex items-center justify-start",
                      children: [(0, r.jsx)("img", {
                        alt: "",
                        src: "/images/witness-yellow-mini.svg",
                        className: "h-3 w-auto mr-0.5"
                      }), (0, r.jsx)("span", {className: "text-xs", children: e.numberOfValidWitnesses || 0})]
                    }), (0, r.jsxs)("div", {
                      className: "flex items-center justify-start",
                      children: [(0, r.jsx)("img", {
                        alt: "",
                        src: "/images/witness-gray.svg",
                        className: "h-3 w-auto mr-0.5"
                      }), (0, r.jsx)("span", {className: "text-xs", children: e.numberOfInvalidWitnesses || 0})]
                    })]
                  })
                })]
              });
            case"assert_location_v1":
            case"assert_location_v2":
              return (0, r.jsxs)("span", {
                className: "flex items-center space-x-1",
                children: [(0, r.jsx)("img", {
                  alt: "",
                  src: "/images/location-hex.svg",
                  className: "h-3 w-auto mr-1"
                }), e.location]
              });
            case"payment_v1":
              return (0, r.jsxs)("span", {
                className: "flex items-center space-x-2",
                children: [(0, r.jsxs)("div", {
                  className: "flex items-center justify-end text-gray-600",
                  children: [(0, r.jsx)(Ea, {size: 12, address: e.payer}), (0, r.jsx)("span", {
                    className: "pl-1 ",
                    children: (0, r.jsx)(he, {clickable: !1, address: e.payer, truncate: 4, mono: !0})
                  })]
                }), (0, r.jsx)(ht, {className: "text-gray-600 rotate-90 transform h-3 w-auto"}), (0, r.jsxs)("div", {
                  className: "flex items-center justify-end text-gray-600",
                  children: [(0, r.jsx)(Ea, {size: 12, address: e.payee}), (0, r.jsx)("span", {
                    className: "pl-1 ",
                    children: (0, r.jsx)(he, {clickable: !1, address: e.payee, truncate: 4, mono: !0})
                  })]
                })]
              });
            case"payment_v2":
              return (0, r.jsxs)("span", {
                className: "flex items-center space-x-2",
                children: [(0, r.jsxs)("div", {
                  className: "flex items-center justify-end text-gray-600",
                  children: [(0, r.jsx)(Ea, {size: 12, address: e.payer}), (0, r.jsx)("span", {
                    className: "pl-1 ",
                    children: (0, r.jsx)(he, {clickable: !1, address: e.payer, truncate: 4, mono: !0})
                  })]
                }), (0, r.jsx)(ht, {className: "text-gray-600 rotate-90 transform h-3 w-auto"}), 1 === e.payments.length ? (0, r.jsxs)("div", {
                  className: "flex items-center justify-end text-gray-600",
                  children: [(0, r.jsx)(Ea, {
                    size: 12,
                    address: e.payments[0].payee
                  }), (0, r.jsx)("span", {
                    className: "pl-1 ",
                    children: (0, r.jsx)(he, {clickable: !1, address: e.payments[0].payee, truncate: 4, mono: !0})
                  })]
                }) : (0, r.jsxs)("div", {
                  className: "flex items-center justify-end text-gray-600",
                  children: [e.payments.length, " payees"]
                })]
              });
            case"stake_validator_v1":
              return (0, r.jsxs)("span", {
                className: "flex items-center space-x-1 md:space-x-3",
                children: [(0, r.jsxs)("div", {
                  className: "flex items-center justify-end text-gray-600",
                  children: [(0, r.jsx)(Ea, {size: 12, address: e.owner}), (0, r.jsx)("span", {
                    className: "pl-1 ",
                    children: (0, r.jsx)(he, {clickable: !1, address: e.owner, truncate: 4, mono: !0})
                  })]
                }), (0, r.jsxs)("span", {
                  className: "flex items-center justify-start space-x-1",
                  children: [(0, r.jsx)("img", {
                    alt: "",
                    src: "/images/hnt.svg",
                    className: "w-4 mr-1"
                  }), e.stake.toString(2)]
                })]
              });
            case"validator_heartbeat_v1":
              return (0, r.jsxs)("span", {
                className: "flex items-center",
                children: [(0, r.jsx)("svg", {
                  xmlns: "http://www.w3.org/2000/svg",
                  className: "h-3 w-3 text-txn-heartbeat",
                  viewBox: "0 0 20 20",
                  fill: "currentColor",
                  children: (0, r.jsx)("path", {
                    fillRule: "evenodd",
                    d: "M3.172 5.172a4 4 0 015.656 0L10 6.343l1.172-1.171a4 4 0 115.656 5.656L10 17.657l-6.828-6.829a4 4 0 010-5.656z",
                    clipRule: "evenodd"
                  })
                }), (0, r.jsx)("span", {className: "ml-1", children: Pa(e.version)})]
              });
            default:
              return t
          }
        }), []), p = (0, a.useCallback)((function (e) {
          return null
        }), []), x = (0, a.useCallback)((function (e) {
          return (0, r.jsxs)(r.Fragment, {
            children: [(0, r.jsx)(Ji, {highlightColor: Xr(e.type)}), (0, r.jsxs)("div", {
              className: "w-full px-4 py-2",
              children: [(0, r.jsx)("div", {
                className: "text-sm md:text-base font-medium text-darkgray-800 font-sans whitespace-nowrap",
                children: f(e)
              }), (0, r.jsx)("div", {
                className: "text-sm md:text-base font-medium text-darkgray-800 font-sans whitespace-nowrap",
                children: m(e)
              }), (0, r.jsx)("div", {
                className: "flex items-center space-x-4 h-6 text-gray-525 text-xs md:text-sm whitespace-nowrap",
                children: h(e)
              })]
            }), (0, r.jsx)("div", {
              className: "flex items-center px-4 text-xs md:text-sm font-sans text-gray-525",
              children: p(e)
            }), d && (0, r.jsx)("div", {
              className: "flex items-center px-4",
              children: (0, r.jsx)("img", {alt: "", src: "/images/details-arrow.svg"})
            })]
          })
        }), [d, p, h, m, f]);
      return (0, r.jsx)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !o,
          "overflow-y-hidden": o
        }),
        children: (0, r.jsx)(In, {
          items: s,
          keyExtractor: u,
          linkExtractor: d,
          isLoading: !s || o,
          fetchMore: i,
          isLoadingMore: l,
          hasMore: c,
          renderDetails: p,
          blankTitle: "No Transactions",
          renderItem: x,
          render: !0,
          itemPadding: !1
        })
      })
    }, Xi = (0, a.memo)(Yi);

    function Qi(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var eo = function () {
      var e, t = Nr().height, n = (0, i.UO)().block, s = (0, a.useState)({}), o = s[0], l = s[1],
        c = (0, a.useState)(!0), u = c[0], d = c[1];
      (0, Ui.r5)((e = f().mark((function e() {
        var t;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return d(!0), e.next = 3, Sr(n);
            case 3:
              t = e.sent, l(t), d(!1);
            case 6:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            Qi(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Qi(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), [n]);
      var m = (0, a.useMemo)((function () {
        var e = parseInt(n);
        return (0, r.jsxs)("span", {
          className: "flex items-end justify-start",
          children: ["Block ", e.toLocaleString(), (0, r.jsxs)("span", {
            className: "ml-2 flex items-end justify-start mb-1",
            children: [(0, r.jsx)(qi, {
              classes: "opacity-75",
              linkPath: "/blocks/".concat(e - 1),
              icon: (0, r.jsx)(zi, {classes: "h-4 w-4 text-white"})
            }), t > e && (0, r.jsx)(qi, {
              classes: "ml-0.5 opacity-75",
              linkPath: "/blocks/".concat(e + 1),
              icon: (0, r.jsx)(Ki, {classes: "h-4 w-4 text-white"})
            })]
          })]
        })
      }), [n, t]), h = function (e) {
        return u ? [[{
          iconPath: "/images/clock.svg",
          loading: !0,
          skeletonClasses: "w-32"
        }, {iconPath: "/images/txn.svg", loading: !0, skeletonClasses: "w-32"}], [{
          iconPath: "/images/block-purple.svg",
          loading: !0,
          skeletonClasses: "w-32"
        }]] : [[{
          iconPath: "/images/clock.svg",
          title: (0, r.jsx)($i, {blockHash: e.hash, blockTime: e.time})
        }, {
          iconPath: "/images/txn.svg",
          title: "".concat(e.transactionCount, " transactions")
        }], [{iconPath: "/images/block-purple.svg", title: "".concat(Qr(e.hash)), textToCopy: e.hash}]]
      };
      return u ? (0, r.jsx)(pt, {title: m, subtitles: h(o), children: (0, r.jsx)(Cn, {})}) : (0, r.jsx)(pt, {
        title: m,
        metaTitle: "Block ".concat(parseInt(n).toLocaleString()),
        subtitles: h(o),
        breadcrumbs: [{title: "Blocks", path: "/blocks/latest"}],
        children: (0, r.jsx)(Xi, {height: n})
      })
    }, to = function (e) {
      var t = e.count;
      return (0, r.jsx)(fe.Z, {
        title: "".concat(t, " witnesses"),
        children: (0, r.jsxs)("span", {
          className: "px-3 py-1 text-white text-xs font-medium rounded-full bg-yellow-500 flex items-center justify-center space-x-1",
          children: [(0, r.jsx)("img", {
            alt: "",
            style: {height: 10},
            src: "/images/witness-mini.svg"
          }), (0, r.jsx)("span", {children: t})]
        })
      })
    }, no = function (e) {
      var t = e.beacons, n = e.isLoading, s = void 0 === n || n, i = e.fetchMore, o = e.isLoadingMore, l = e.hasMore,
        c = (0, a.useCallback)((function (e) {
          console.log("selecting beacon", e)
        }), []), u = (0, a.useCallback)((function (e) {
          return e.hash
        }), []), d = (0, a.useCallback)((function (e) {
          return "/txns/".concat(e.hash)
        }), []), f = (0, a.useCallback)((function (e) {
          return (0, r.jsx)(de, {geocode: e.path[0].geocode, shortenedLocationName: !0})
        }), []), m = (0, a.useCallback)((function (e) {
          return (0, r.jsx)(vr.Z, {date: 1e3 * e.time})
        }), []), h = (0, a.useCallback)((function (e) {
          var t, n;
          return (0, r.jsx)(to, {count: (null === (t = e.path[0]) || void 0 === t || null === (n = t.witnesses) || void 0 === n ? void 0 : n.length) || 0})
        }), []);
      return (0, r.jsx)(In, {
        items: t,
        keyExtractor: u,
        linkExtractor: d,
        onSelectItem: c,
        isLoading: s,
        renderTitle: f,
        renderSubtitle: m,
        renderDetails: h,
        blankTitle: "No Beacons",
        fetchMore: i,
        isLoadingMore: o,
        hasMore: l
      })
    }, ro = function (e) {
      var t = function (e, t) {
        var n = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 20, r = (0, a.useState)(), s = r[0],
          i = r[1], o = (0, a.useState)([]), l = o[0], c = o[1], u = (0, a.useState)(!0), d = u[0], h = u[1],
          p = (0, a.useState)(!1), x = p[0], v = p[1], g = (0, a.useState)(!0), y = g[0], j = g[1];
        (0, Qt.r5)(Ir(f().mark((function n() {
          var r;
          return f().wrap((function (n) {
            for (; ;) switch (n.prev = n.next) {
              case 0:
                if (void 0 !== e && void 0 !== t) {
                  n.next = 7;
                  break
                }
                return n.next = 4, m.ZP.challenges.list();
              case 4:
                r = n.sent, n.next = 17;
                break;
              case 7:
                if ("hotspot" !== e) {
                  n.next = 13;
                  break
                }
                return n.next = 10, m.ZP.hotspot(t).challenges.list();
              case 10:
                r = n.sent, n.next = 17;
                break;
              case 13:
                if ("account" !== e) {
                  n.next = 17;
                  break
                }
                return n.next = 16, m.ZP.account(t).challenges.list();
              case 16:
                r = n.sent;
              case 17:
                i(r);
              case 18:
              case"end":
                return n.stop()
            }
          }), n)
        }))), []), (0, Qt.r5)(Ir(f().mark((function e() {
          var t;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                if (s) {
                  e.next = 2;
                  break
                }
                return e.abrupt("return");
              case 2:
                return v(!0), e.next = 5, s.take(n);
              case 5:
                t = e.sent, c(t), v(!1), h(!1), t.length < n && j(!1);
              case 10:
              case"end":
                return e.stop()
            }
          }), e)
        }))), [s]);
        var w = (0, a.useCallback)(Ir(f().mark((function e() {
          var t;
          return f().wrap((function (e) {
            for (; ;) switch (e.prev = e.next) {
              case 0:
                return e.next = 2, s.take(n);
              case 2:
                t = e.sent, c(Br(l).concat(Br(t)));
              case 4:
              case"end":
                return e.stop()
            }
          }), e)
        }))), [s, n, l]);
        return {items: l, fetchMore: w, isLoadingInitial: d, isLoadingMore: x, hasMore: y}
      }(e.context, e.address), n = t.items, s = t.fetchMore, i = t.isLoadingInitial, o = t.isLoadingMore, l = t.hasMore;
      return (0, r.jsx)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !i,
          "overflow-y-hidden": i
        }), children: (0, r.jsx)(no, {beacons: n, isLoading: i, isLoadingMore: o, fetchMore: s, hasMore: l})
      })
    }, ao = function () {
      return (0, r.jsx)(pt, {
        title: "Beacons",
        metaTitle: "Beacons",
        children: (0, r.jsx)(pn, {
          htmlTitleRoot: "Beacons",
          children: (0, r.jsx)(hn, {title: "All Beacons", children: (0, r.jsx)(ro, {})})
        })
      })
    }, so = function (e) {
      var t = e.errorType, n = void 0 === t ? 404 : t, a = e.errorTitle, s = void 0 === a ? "404 \u2014 Not Found" : a,
        o = e.warningTitle, l = void 0 === o ? "This page doesn't exist" : o, c = e.breadcrumbs, u = e.subtitleText,
        d = (0, i.TH)().pathname,
        f = 404 === n ? "https://github.com/helium/explorer/issues/new?labels=bug&template=bug_report.yml&title=%5BBug%5D%3A+404%20error%20at%20URL:%20".concat(d) : "https://github.com/helium/explorer/issues/new?labels=bug&template=bug_report.yml&title=%5BBug%5D%3A+".concat(n, "%20error%20at%20URL:%20").concat(d);
      return (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsx)(st.q, {
          children: (0, r.jsx)("meta", {
            name: "robots",
            content: "noindex"
          })
        }), (0, r.jsx)(pt, {
          title: s,
          subtitles: u ? [[{iconPath: "/images/warning.svg", title: u}]] : [],
          breadcrumbs: c,
          children: (0, r.jsxs)(Dt, {
            children: [(0, r.jsx)($r, {
              warningText: 404 === n ? l : "Something went wrong",
              isVisible: !0
            }), (0, r.jsx)(At, {
              span: 2,
              title: "Create an issue on GitHub",
              value: "Report a bug",
              linkTo: f
            }), (0, r.jsx)(At, {
              span: 2,
              title: "Ask the community for help",
              value: "Join the Discord",
              linkTo: "https://discord.gg/9WpdzeSpE7"
            })]
          })
        })]
      })
    }, io = function () {
      var e = (0, i.UO)().hash, t = (0, Se.Z)(), n = t.selectedTxn, s = t.selectTxn, o = t.clearSelectedTxn;
      (0, a.useEffect)((function () {
        n || s(e)
      }), [e, s, n]), (0, a.useEffect)((function () {
        return function () {
          o()
        }
      }), [o]);
      var l;
      return n && 0 === Object.keys(n).length ? (0, r.jsx)(so, {
        subtitleText: "Double check the transaction hash",
        errorTitle: "404 \u2014 Transaction Not Found",
        warningTitle: "Transaction hash didn't match any transactions.",
        breadcrumbs: [{title: "Blocks", path: "/blocks/latest"}]
      }) : (0, r.jsx)(pt, {
        title: (l = n, l ? (0, r.jsxs)("span", {
          className: "flex items-start justify-start",
          children: [(0, r.jsx)("span", {
            className: "h-5 md:h-7 w-1 -ml-4 mt-1.5 opacity-75",
            style: {backgroundColor: Xr(l.type)}
          }), (0, r.jsxs)("span", {className: "ml-3", children: [Yr(l.type), " transaction"]})]
        }) : "Loading transaction..."),
        metaTitle: "Transaction ".concat(e),
        breadcrumbs: function (e) {
          return e ? [{title: "Blocks", path: "/blocks/latest"}, {
            title: "".concat(e.height.toLocaleString()),
            path: "/blocks/".concat(e.height)
          }] : [{title: "Blocks", path: "/blocks/latest"}, {title: "..."}]
        }(n),
        subtitles: function (e) {
          return e ? [[{
            title: (0, r.jsx)($i, {blockHeight: e.height, blockTime: e.time}),
            iconPath: "/images/clock.svg"
          }, {
            title: Qr(e.hash),
            textToCopy: e.hash,
            iconPath: "/images/address.svg"
          }]] : [[{iconPath: "/images/clock.svg", loading: !0}, {iconPath: "/images/address.svg", loading: !0}]]
        }(n),
        children: (0, r.jsx)("div", {
          className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
            "overflow-y-scroll": n,
            "overflow-y-hidden": !n
          }), children: (0, r.jsx)(ws, {txn: n, isLoading: !n})
        })
      })
    };

    function oo(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function lo(e) {
      return function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            oo(s, r, a, i, o, "next", e)
          }

          function o(e) {
            oo(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }
    }

    function co(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function uo(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          co(e, t, n[t])
        }))
      }
      return e
    }

    var fo = function () {
      var e = lo(f().mark((function e(t) {
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.abrupt("return", m.ZP.accounts.get(t));
            case 1:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function (t) {
        return e.apply(this, arguments)
      }
    }(), mo = function (e) {
      var t, n = "accounts/".concat(e), r = (0, Rt.ZP)(n, (t = e, function () {
        return fo(t)
      }), {refreshInterval: 6e4}), a = r.data, s = r.error;
      return {account: a, isLoading: !s && !a, isError: s}
    }, ho = function () {
      var e = lo(f().mark((function e() {
        var t, n, r;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return e.next = 2, m.ZP.accounts.listRich();
            case 2:
              return e.next = 4, e.sent.take(100);
            case 4:
              return t = e.sent, e.next = 7, m.ZP.stats.get();
            case 7:
              return n = e.sent, r = t.map((function (e, t) {
                return uo({}, e, {
                  rank: t + 1,
                  hntPercent: e.balance.plus(e.stakedBalance).floatBalance / n.tokenSupply * 100,
                  hstPercent: e.secBalance.floatBalance / 1e4 * 100
                })
              })), e.abrupt("return", r);
            case 10:
            case"end":
              return e.stop()
          }
        }), e)
      })));
      return function () {
        return e.apply(this, arguments)
      }
    }(), po = function (e) {
      var t = e.title, n = e.children;
      return (0, r.jsxs)("div", {
        className: "w-1/3 flex flex-col",
        children: [(0, r.jsx)("span", {
          className: "text-xs uppercase tracking-wider",
          children: t
        }), (0, r.jsx)("span", {className: "flex space-x-0.5 text-black", children: n})]
      })
    }, xo = function (e) {
      var t = e.accounts, n = (0, a.useCallback)((function (e) {
        return e.address
      }), []), s = (0, a.useCallback)((function (e) {
        return "/accounts/".concat(e.address)
      }), []), i = (0, a.useCallback)((function (e) {
        return (0, r.jsxs)("div", {
          className: "flex items-center justify-start space-x-1",
          children: [(0, r.jsx)(Ea, {address: e.address, size: 18}), (0, r.jsx)(he, {address: e.address, truncate: !0})]
        })
      }), []), o = (0, a.useCallback)((function (e) {
        return (0, r.jsxs)("div", {
          className: "flex items-center space-x-2 w-full mt-2",
          children: [(0, r.jsxs)(po, {
            title: "Total Balance",
            children: [(0, r.jsx)("img", {
              src: "/images/hnt.svg",
              className: "w-3 mr-0.5"
            }), (0, r.jsx)(Fr, {value: e.balance.floatBalance + e.stakedBalance.floatBalance, precision: 2})]
          }), (0, r.jsx)(po, {
            title: "Staked Balance",
            children: 0 === e.stakedBalance.floatBalance ? (0, r.jsx)("span", {
              className: "text-gray-550",
              children: "none"
            }) : (0, r.jsxs)(r.Fragment, {
              children: [(0, r.jsx)("img", {
                src: "/images/hnt.svg",
                className: "w-3 mr-0.5"
              }), (0, r.jsx)(Fr, {value: e.stakedBalance.floatBalance, precision: 2})]
            })
          }), (0, r.jsx)(po, {
            title: "HST Balance",
            children: 0 === e.secBalance.floatBalance ? (0, r.jsx)("span", {
              className: "text-gray-550",
              children: "none"
            }) : (0, r.jsxs)(r.Fragment, {
              children: [(0, r.jsx)("img", {
                src: "/images/hst.svg",
                className: "w-3 mr-0.5"
              }), (0, r.jsx)(Fr, {value: e.secBalance.floatBalance, precision: 2})]
            })
          })]
        })
      }), []), l = (0, a.useCallback)((function (e) {
        return (0, r.jsxs)("span", {children: ["#", e.rank]})
      }), []), c = (0, a.useCallback)((function (e) {
        return (0, r.jsxs)(r.Fragment, {
          children: [(0, r.jsxs)("div", {
            className: "w-full",
            children: [(0, r.jsx)("div", {
              className: "text-sm md:text-base font-medium text-darkgray-800 font-sans",
              children: i(e)
            }), (0, r.jsx)("div", {
              className: "flex items-center space-x-4 h-10 text-gray-525 text-xs md:text-sm whitespace-nowrap",
              children: o(e)
            })]
          }), (0, r.jsx)("div", {
            className: "flex items-center px-4 text-xs md:text-sm font-sans text-gray-525",
            children: l(e)
          }), (0, r.jsx)("div", {
            className: "flex items-center",
            children: (0, r.jsx)("img", {src: "/images/details-arrow.svg"})
          })]
        })
      }), [l, o, i]);
      return (0, r.jsx)(In, {
        items: t,
        keyExtractor: n,
        linkExtractor: s,
        isLoading: !1,
        renderItem: c,
        blankTitle: "No accounts"
      })
    }, vo = function () {
      var e = function () {
        var e = (0, Rt.ZP)("accounts/richest", ho, {refreshInterval: 6e4}), t = e.data, n = e.error;
        return {accounts: t, isLoading: !n && !t, isError: n}
      }(), t = e.accounts, n = e.isLoading;
      return (0, r.jsx)(pt, {
        title: "Accounts",
        metaTitle: "Accounts",
        children: (0, r.jsxs)(pn, {
          htmlTitleRoot: "Accounts",
          children: [(0, r.jsx)(hn, {
            title: "Overview",
            children: (0, r.jsx)("div", {})
          }, "overview"), (0, r.jsx)(hn, {
            title: "Richest",
            path: "richest",
            children: (0, r.jsx)(Dt, {
              span: 1,
              padding: !1,
              children: n ? (0, r.jsx)(Cn, {}) : (0, r.jsx)(xo, {accounts: t})
            })
          }, "richest")]
        })
      })
    }, go = n(1653), yo = function (e) {
      var t = e.address;
      return t ? (0, r.jsxs)("div", {
        className: "col-span-2 flex space-x-4",
        children: [(0, r.jsx)("div", {
          className: "flex",
          children: (0, r.jsx)(go.Z, {value: t, size: 100})
        }), (0, r.jsx)(At, {
          title: "QR Code",
          titleIcon: (0, r.jsx)("img", {alt: "QR Code icon", src: "/images/qr.svg"}),
          subtitle: "HNT can be sent to this account using the QR feature in the Helium App."
        })]
      }) : null
    }, jo = function (e) {
      return "0" === e ? (0, r.jsx)(wo, {}) : e
    }, wo = function () {
      return (0, r.jsx)("span", {className: "text-3xl text-gray-500", children: "none"})
    }, bo = function (e) {
      var t, n, s, i, o, l, c, u = e.account, d = zt().market, f = (0, a.useMemo)((function () {
        var e;
        return null === u || void 0 === u || null === (e = u.balance) || void 0 === e ? void 0 : e.plus(null === u || void 0 === u ? void 0 : u.stakedBalance)
      }), [u]);
      return (0, r.jsxs)("div", {
        className: "bg-gray-200 p-3 rounded-lg col-span-2",
        children: [(0, r.jsx)("div", {
          className: "text-gray-600 text-sm whitespace-nowrap",
          children: "Total HNT Balance"
        }), (0, r.jsxs)("div", {
          className: "my-1.5",
          children: [(0, r.jsx)("div", {
            className: "text-3xl font-medium text-black tracking-tight w-full break-all",
            children: u ? jo(null === f || void 0 === f ? void 0 : f.toString(2, {showTicker: !1})) : (0, r.jsx)(me, {className: "w-1/2 my-2.5"})
          }), (0, r.jsx)("div", {
            className: "text-base text-gray-600 tracking-tight w-full break-all",
            children: u && d ? (0, r.jsx)(Zt, {value: null === (t = null === f || void 0 === f ? void 0 : f.times(null === d || void 0 === d ? void 0 : d.price)) || void 0 === t ? void 0 : t.floatBalance}) : (0, r.jsx)(me, {className: "w-1/3 my-2"})
          })]
        }), (0, r.jsxs)("div", {
          className: "flex space-x-4",
          children: [(0, r.jsxs)("div", {
            className: "flex space-x-1 align-middle",
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/dc.svg"
            }), u ? (0, r.jsx)("span", {
              className: ce()("text-sm whitespace-nowrap", {"text-gray-600": 0 === (null === u || void 0 === u || null === (n = u.dcBalance) || void 0 === n ? void 0 : n.integerBalance)}),
              children: null === u || void 0 === u || null === (s = u.dcBalance) || void 0 === s ? void 0 : s.toString(0, {showTicker: !0})
            }) : (0, r.jsx)(me, {className: "w-10 my-1"})]
          }), (0, r.jsxs)("div", {
            className: "flex space-x-1 align-middle",
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/hst.svg"
            }), u ? (0, r.jsx)("span", {
              className: ce()("text-sm whitespace-nowrap", {"text-gray-600": 0 === (null === u || void 0 === u || null === (i = u.secBalance) || void 0 === i ? void 0 : i.integerBalance)}),
              children: null === u || void 0 === u || null === (o = u.secBalance) || void 0 === o ? void 0 : o.toString(2, {showTicker: !0})
            }) : (0, r.jsx)(me, {className: "w-10 my-1"})]
          }), (0, r.jsxs)("div", {
            className: "flex space-x-1 align-middle",
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/validator.svg"
            }), u ? (0, r.jsxs)("span", {
              className: ce()("text-sm whitespace-nowrap", {"text-gray-600": 0 === (null === u || void 0 === u || null === (l = u.stakedBalance) || void 0 === l ? void 0 : l.integerBalance)}),
              children: [null === u || void 0 === u || null === (c = u.stakedBalance) || void 0 === c ? void 0 : c.toString(2, {showTicker: !0}), " staked"]
            }) : (0, r.jsx)(me, {className: "w-16 my-1"})]
          })]
        })]
      })
    }, ko = function (e) {
      return 0 === e ? (0, r.jsx)(No, {}) : null === e || void 0 === e ? void 0 : e.toLocaleString()
    }, No = function () {
      return (0, r.jsx)("span", {className: "text-3xl text-gray-500", children: "None"})
    }, So = function () {
      var e = (0, i.UO)().address, t = mo(e).account;
      return (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(bo, {account: t}), (0, r.jsx)(yo, {address: e}), (0, r.jsx)(qr, {
          address: null === t || void 0 === t ? void 0 : t.address,
          type: "account",
          title: "Earnings (UTC)"
        }), (0, r.jsx)(At, {
          title: "Hotspots",
          isLoading: !t,
          value: ko(null === t || void 0 === t ? void 0 : t.hotspotCount),
          linkTo: "/accounts/".concat(e, "/hotspots")
        }), (0, r.jsx)(At, {
          title: "Validators",
          isLoading: !t,
          value: ko(null === t || void 0 === t ? void 0 : t.validatorCount),
          linkTo: "/accounts/".concat(e, "/validators")
        })]
      })
    }, Co = function (e) {
      var t = e.address, n = mo(t).account, a = (0, vn.vy)("account", t), s = a.hotspots, i = a.fetchMore,
        o = a.isLoadingInitial, l = a.isLoadingMore, c = a.hasMore;
      return (0, r.jsx)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !o,
          "overflow-y-hidden": o
        }),
        children: (0, r.jsx)(rr, {
          hotspots: s,
          isLoading: o,
          isLoadingMore: l,
          fetchMore: i,
          hasMore: c,
          count: null === n || void 0 === n ? void 0 : n.hotspotCount,
          showCount: !0
        })
      })
    }, Lo = function (e) {
      var t = e.address, n = mo(t).account, s = function (e) {
          var t, n = "account/".concat(e, "/validators"), r = (0, Rt.ZP)(n, (t = e, function () {
            return on(t)
          }), {refreshInterval: 6e4}), a = r.data, s = r.error;
          return {validators: a, isLoading: !s && !a, isError: s}
        }(t), i = s.validators, o = s.isLoading, l = Ti(), c = l.consensusGroups, u = l.isLoading,
        d = (0, a.useMemo)((function () {
          return (null === c || void 0 === c ? void 0 : c.recentElections) || []
        }), [c]), f = (0, a.useMemo)((function () {
          return o || u
        }), [o, u]);
      return f ? (0, r.jsx)(Cn, {}) : (0, r.jsx)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !f,
          "overflow-y-hidden": f
        }),
        children: (0, r.jsx)(Bi, {
          validators: i,
          recentGroups: d,
          isLoading: f,
          count: null === n || void 0 === n ? void 0 : n.validatorCount,
          showCount: !0
        })
      })
    }, To = function (e) {
      var t, n, s, i, o, l, c = e.account, u = (0, a.useMemo)((function () {
        var e;
        return null === c || void 0 === c || null === (e = c.balance) || void 0 === e ? void 0 : e.plus(null === c || void 0 === c ? void 0 : c.stakedBalance)
      }), [c]);
      return (0, r.jsxs)("div", {
        className: "bg-gray-200 p-3 rounded-lg col-span-2",
        children: [(0, r.jsxs)("div", {
          className: "flex space-x-1 text-gray-600 text-sm whitespace-nowrap",
          children: [(0, r.jsx)("img", {src: "/images/dc.svg"}), (0, r.jsx)("span", {children: "DC Balance"})]
        }), (0, r.jsxs)("div", {
          className: "my-1.5",
          children: [(0, r.jsx)("div", {
            className: "text-3xl font-medium text-black tracking-tight w-full break-all",
            children: c ? (0, r.jsx)("span", {children: null === c || void 0 === c || null === (t = c.dcBalance) || void 0 === t ? void 0 : t.toString(0)}) : (0, r.jsx)(me, {className: "w-1/2 my-2.5"})
          }), (0, r.jsx)("div", {
            className: "text-base text-gray-600 tracking-tight w-full break-all",
            children: c ? (0, r.jsx)(Zt, {value: null === c || void 0 === c || null === (n = c.dcBalance) || void 0 === n ? void 0 : n.toUsd().floatBalance}) : (0, r.jsx)(me, {className: "w-1/3 my-2"})
          })]
        }), (0, r.jsxs)("div", {
          className: "flex space-x-4",
          children: [(0, r.jsxs)("div", {
            className: "flex space-x-1 align-middle",
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/hnt.svg",
              className: "w-4"
            }), c ? (0, r.jsx)("span", {
              className: ce()("text-sm whitespace-nowrap", {"text-gray-600": 0 === (null === u || void 0 === u ? void 0 : u.integerBalance)}),
              children: null === u || void 0 === u ? void 0 : u.toString(2)
            }) : (0, r.jsx)(me, {className: "w-10 my-1"})]
          }), (0, r.jsxs)("div", {
            className: "flex space-x-1 align-middle",
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/hst.svg",
              className: "w-4"
            }), c ? (0, r.jsx)("span", {
              className: ce()("text-sm whitespace-nowrap", {"text-gray-600": 0 === (null === c || void 0 === c || null === (s = c.secBalance) || void 0 === s ? void 0 : s.integerBalance)}),
              children: null === c || void 0 === c || null === (i = c.secBalance) || void 0 === i ? void 0 : i.toString(2, {showTicker: !0})
            }) : (0, r.jsx)(me, {className: "w-10 my-1"})]
          }), (0, r.jsxs)("div", {
            className: "flex space-x-1 align-middle",
            children: [(0, r.jsx)("img", {
              alt: "",
              src: "/images/validator.svg"
            }), c ? (0, r.jsxs)("span", {
              className: ce()("text-sm whitespace-nowrap", {"text-gray-600": 0 === (null === c || void 0 === c || null === (o = c.stakedBalance) || void 0 === o ? void 0 : o.integerBalance)}),
              children: [null === c || void 0 === c || null === (l = c.stakedBalance) || void 0 === l ? void 0 : l.toString(2, {showTicker: !0}), " staked"]
            }) : (0, r.jsx)(me, {className: "w-16 my-1"})]
          })]
        })]
      })
    }, Po = function () {
      var e, t, n, a, s, o, l = (0, i.UO)().address, c = mo(l).account, u = A(l).maker, d = zt().market;
      return (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(To, {account: c}), (0, r.jsx)(yo, {address: l}), (0, r.jsx)(At, {
          title: "HNT Burned",
          titleIcon: (0, r.jsx)(sr, {className: "text-orange-300 w-3 h-auto"}),
          isLoading: !u || !d,
          value: null === u || void 0 === u || null === (e = u.burnedHNT) || void 0 === e ? void 0 : e.toString(2, {showTicker: !1}),
          subtitle: (0, r.jsx)(Zt, {value: (null === u || void 0 === u || null === (t = u.burnedHNT) || void 0 === t ? void 0 : t.floatBalance) * (null === d || void 0 === d ? void 0 : d.price)})
        }), (0, r.jsx)(At, {
          title: "Onboards Remaining",
          isLoading: !u,
          value: null === u || void 0 === u ? void 0 : u.assertsRemaining.toLocaleString(),
          subtitle: (0, r.jsx)("span", {className: "text-xs", children: "5M DC ($50) per onboard"}),
          tooltip: "The number of hotspots this Maker could afford to onboard given their current DC balance, assuming a cost of 5M DC ($50) for each hotspot: 4M DC ($40) to add it to the blockchain, and 1M DC ($10) to assert its location"
        }), (0, r.jsx)(At, {
          title: "Hotspots Added",
          titleIcon: (0, r.jsx)(pe, {className: "text-green-500 w-3 h-auto"}),
          isLoading: !u,
          value: null === u || void 0 === u || null === (n = u.txns) || void 0 === n || null === (a = n.addGatewayTxns) || void 0 === a ? void 0 : a.toLocaleString(),
          subtitle: (0, r.jsx)("span", {className: "text-xs", children: "4M DC ($40) per add"})
        }), (0, r.jsx)(At, {
          title: "Locations Asserted",
          titleIcon: (0, r.jsx)(xe, {className: "text-pink-500 w-3 h-auto"}),
          isLoading: !u,
          value: null === u || void 0 === u || null === (s = u.txns) || void 0 === s || null === (o = s.assertLocationTxns) || void 0 === o ? void 0 : o.toLocaleString(),
          subtitle: (0, r.jsx)("span", {className: "text-xs", children: "1M DC ($10) per assert"})
        })]
      })
    }, Ao = function () {
      var e = (0, i.UO)().address, t = A(e), n = t.maker, s = t.isLoading, o = (0, a.useMemo)((function () {
        return n ? [[{
          title: null === n || void 0 === n ? void 0 : n.name,
          tooltip: "This is a Maker Account",
          iconPath: "/images/maker.svg"
        }]] : [[]]
      }), [n]), l = (0, a.useCallback)((function () {
        return s ? (0, r.jsx)(xi, {}) : n ? (0, r.jsx)(Po, {}) : (0, r.jsx)(So, {})
      }), [s, n]);
      return (0, r.jsx)(pt, {
        title: (0, r.jsxs)("span", {
          className: "flex items-center justify-start",
          children: [(0, r.jsx)(Ea, {address: e, size: 28, className: "mr-2 mt-0.5"}), (0, r.jsx)(ct, {
            textToCopy: e,
            tooltip: "Copy address",
            children: (0, r.jsx)(he, {address: e, truncate: 5})
          })]
        }),
        metaTitle: "Account ".concat(e),
        subtitles: o,
        breadcrumbs: n ? [{title: "Makers", path: "/hotspots/makers"}] : [{title: "Overview", path: "/"}],
        children: (0, r.jsxs)(pn, {
          htmlTitleRoot: "Account ".concat(e.slice(0, 4), "..."),
          children: [(0, r.jsx)(hn, {title: "Overview", children: l()}, "overview"), (0, r.jsx)(hn, {
            title: "Activity",
            path: "activity",
            children: s ? (0, r.jsx)(An, {}) : (0, r.jsx)(ui, {context: "account", address: e})
          }, "activity"), (0, r.jsx)(hn, {
            title: "Hotspots",
            path: "hotspots",
            children: (0, r.jsx)(Co, {address: e})
          }, "hotspots"), (0, r.jsx)(hn, {
            title: "Validators",
            path: "validators",
            children: (0, r.jsx)(Lo, {address: e})
          }, "validators")]
        })
      })
    }, Mo = function () {
      return (0, r.jsxs)("span", {
        children: ["Penalties and probability determine whether a Validator is elected to or removed from a consensus group.", " ", (0, r.jsx)("a", {
          href: "https://docs.helium.com/mine-hnt/validators/penalties/",
          target: "_blank",
          rel: "noopener noreferrer",
          children: "Learn More"
        })]
      })
    }, _o = function (e) {
      var t = e.validator, n = {};
      (null === t || void 0 === t ? void 0 : t.penalties) && t.penalties.forEach((function (e) {
        var t = e.type, r = e.amount;
        n[t] ? n[t] += r : n[t] = r
      }));
      var a = (0, c.sum)(Object.values(n)), s = function (e) {
        return (0, c.round)(n[e] / a * 100) + "%"
      }, i = function (e) {
        switch (e) {
          case"performance":
            return "#474DFF";
          case"tenure":
            return "#29D391";
          default:
            return "#CCC"
        }
      };
      return (0, r.jsx)("div", {
        className: "h-6 w-full my-3 rounded-lg flex overflow-hidden",
        children: t ? Object.keys(n).map((function (e, t) {
          return (0, r.jsx)(fe.Z, {
            title: "".concat((0, c.capitalize)(e), " (").concat((0, c.round)(n[e], 3), ")"),
            children: (0, r.jsx)("div", {style: {background: i(e), width: s(e), marginRight: 1}}, e)
          })
        })) : (0, r.jsx)("div", {className: "animate-pulse bg-gray-400 w-full"})
      })
    }, Oo = function (e) {
      var t = e.validator;
      return (0, r.jsx)(At, {
        span: 2,
        title: "Penalty Score",
        value: (0, c.round)(null === t || void 0 === t ? void 0 : t.penalty, 3),
        subtitle: (0, r.jsx)(_o, {validator: t}),
        isLoading: !t,
        linkTo: "/validators/".concat(null === t || void 0 === t ? void 0 : t.address, "/penalties"),
        tooltip: (0, r.jsx)(Mo, {})
      })
    }, Ho = function (e) {
      return "0" === e ? (0, r.jsx)(Io, {}) : e
    }, Io = function () {
      return (0, r.jsx)("span", {className: "text-3xl text-gray-500", children: "None"})
    }, Bo = function () {
      var e, t, n, a = (0, i.UO)().address, s = sn(a), o = s.validator, l = s.isLoading, u = Nr(), d = u.height,
        f = u.isLoading;
      return (0, r.jsxs)(Dt, {
        children: [!l && (0, r.jsx)($r, {
          isVisible: (0, ae.HW)(o.status.listenAddrs),
          warningText: "Validator is being Relayed.",
          link: "https://docs.helium.com/mine-hnt/validators/mainnet/deployment-guide",
          linkText: "Learn more"
        }), (0, r.jsx)(At, {
          title: "Status",
          isLoading: l,
          value: (0, r.jsxs)("div", {
            className: "flex items-center space-x-1.5",
            children: [(0, r.jsx)(Ma, {
              includeStatusText: !0,
              status: null === o || void 0 === o ? void 0 : o.status
            }), (0, r.jsx)("span", {children: (0, c.upperFirst)(Ta(null === o || void 0 === o || null === (e = o.status) || void 0 === e ? void 0 : e.online, null === o || void 0 === o || null === (t = o.status) || void 0 === t ? void 0 : t.listen_addrs))})]
          })
        }), (0, r.jsx)(At, {
          title: "Last Heartbeat",
          isLoading: l || f,
          value: (d - (null === o || void 0 === o ? void 0 : o.lastHeartbeat)).toLocaleString(),
          subtitle: (0, r.jsx)("span", {className: "text-gray-600", children: "blocks ago"})
        }), (0, r.jsx)(At, {
          title: "Total HNT Stake",
          isLoading: l,
          value: Ho(null === o || void 0 === o || null === (n = o.stake) || void 0 === n ? void 0 : n.toString(2, {showTicker: !1}))
        }), (0, r.jsx)(At, {
          title: "Version",
          isLoading: l,
          value: Pa(null === o || void 0 === o ? void 0 : o.versionHeartbeat)
        }), (0, r.jsx)(qr, {
          address: null === o || void 0 === o ? void 0 : o.address,
          type: "validator",
          title: "Earnings (UTC)"
        }), (0, r.jsx)(Oo, {validator: o})]
      })
    }, Eo = function () {
      var e = (0, i.UO)().address, t = sn(e), n = t.validator, s = t.isLoading, o = (0, a.useCallback)((function (e) {
        return [e.type, e.height].join("-")
      }), []), l = (0, a.useCallback)((function (e) {
        return (0, r.jsx)("div", {className: "flex items-center space-x-1", children: (0, c.capitalize)(e.type)})
      }), []), u = (0, a.useCallback)((function (e) {
        return (0, r.jsxs)("span", {children: ["Accrued in block ", e.height]})
      }), []), d = (0, a.useCallback)((function (e) {
        return (0, r.jsx)("span", {children: (0, c.round)(e.amount, 3)})
      }), []);
      return (0, r.jsx)(Dt, {
        span: 1,
        padding: !1,
        children: (0, r.jsx)(In, {
          items: null === n || void 0 === n ? void 0 : n.penalties,
          keyExtractor: o,
          listHeaderShowCount: !0,
          listHeaderTitle: "Validator penalties",
          listHeaderDescription: (0, r.jsx)(Mo, {}),
          isLoading: s,
          renderTitle: l,
          renderSubtitle: u,
          renderDetails: d,
          blankTitle: "No penalties"
        })
      })
    }, Fo = function () {
      var e = (0, i.UO)().address, t = sn(e), n = t.validator, s = t.isLoading, o = (0, a.useCallback)((function () {
        return s ? [[[{
          iconPath: "/images/address-symbol.svg",
          loading: !0,
          skeletonClasses: "w-20"
        }, {
          iconPath: "/images/account-green.svg",
          loading: !0,
          skeletonClasses: "w-20"
        }]]] : [[{
          iconPath: "/images/address-symbol.svg",
          title: (0, r.jsx)(he, {address: n.address, truncate: 7}),
          textToCopy: e
        }, {
          iconPath: "/images/account-green.svg",
          title: (0, r.jsxs)("span", {
            className: "flex items-center justify-start",
            children: [(0, r.jsx)(he, {address: n.owner, truncate: 7}), (0, r.jsx)(Ea, {
              address: n.owner,
              className: "h-2.5 md:h-3.5 w-auto ml-0.5"
            })]
          }),
          path: "/accounts/".concat(n.owner)
        }]]
      }), [e, s, n]);
      return (0, r.jsx)(pt, {
        title: bn()(e),
        metaTitle: "Validator ".concat(bn()(e)),
        subtitles: o(),
        breadcrumbs: [{title: "Validators", path: "/validators/all"}],
        children: (0, r.jsxs)(pn, {
          htmlTitleRoot: "".concat(bn()(e)),
          children: [(0, r.jsx)(hn, {
            title: "Overview",
            children: (0, r.jsx)(Bo, {})
          }, "overview"), (0, r.jsx)(hn, {
            title: "Activity",
            path: "activity",
            children: s ? (0, r.jsx)(An, {}) : (0, r.jsx)(ui, {context: "validator", address: e})
          }, "activity"), (0, r.jsx)(hn, {
            title: "Penalties",
            path: "penalties",
            children: s ? (0, r.jsx)(Cn, {}) : (0, r.jsx)(Eo, {})
          }, "penalties")]
        })
      })
    }, Do = function (e) {
      if (!e) return "#AAAAAA";
      var t = 1 / 6;
      return e >= 5 * t ? "#29D344" : e >= 4 * t ? "#9FE14A" : e >= .5 ? "#FCC945" : e >= 2 * t ? "#FEA053" : e >= 1 * t ? "#FC8745" : "#FF6666"
    }, Zo = function (e) {
      var t = e.rewardScale;
      return (0, r.jsxs)("span", {
        className: "flex items-center w-12",
        children: [(0, r.jsx)(tr, {width: 10, height: 12, fillColor: Do(t)}), (0, r.jsx)("span", {
          className: "ml-1",
          children: (null === t || void 0 === t ? void 0 : t.toFixed(2)) || "N/A"
        })]
      })
    }, Ro = function (e) {
      var t = e.hotspot;
      if (!(null === t || void 0 === t ? void 0 : t.timestampAdded)) return null;
      var n = "1970-01-01T00:00:00.000000Z" === t.timestampAdded ? 1564436673e3 : t.timestampAdded;
      return (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsxs)("span", {
          className: "block md:hidden",
          children: [(0, r.jsx)(vr.Z, {date: n, timeStyle: "mini"}), " ago"]
        }), (0, r.jsx)("span", {className: "hidden md:block", children: (0, r.jsx)(vr.Z, {date: n})})]
      })
    };

    function Go(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Vo = function (e) {
      var t = e.address, n = Xn(t, "hotspot", 30, "day").rewards;
      return n ? (0, r.jsxs)("span", {
        className: "flex items-center",
        children: [(0, r.jsx)("img", {
          alt: "",
          src: "/images/hnt.svg",
          className: "w-4 mr-1"
        }), "+", n && (0, c.round)((0, c.sumBy)(n, "total"), 2), " HNT (30d)"]
      }) : (0, r.jsx)(me, {className: "w-32"})
    }, Wo = function (e) {
      var t = e.hotspot, n = (0, a.useState)(!1), s = n[0], i = n[1];
      return (0, a.useEffect)((function () {
        var e = function () {
          var e, n = (e = f().mark((function e() {
            var n;
            return f().wrap((function (e) {
              for (; ;) switch (e.prev = e.next) {
                case 0:
                  return e.next = 2, (0, vn.Nl)(t.address);
                case 2:
                  (null === (n = e.sent) || void 0 === n ? void 0 : n.length) > 0 && i(!0);
                case 4:
                case"end":
                  return e.stop()
              }
            }), e)
          })), function () {
            var t = this, n = arguments;
            return new Promise((function (r, a) {
              var s = e.apply(t, n);

              function i(e) {
                Go(s, r, a, i, o, "next", e)
              }

              function o(e) {
                Go(s, r, a, i, o, "throw", e)
              }

              i(void 0)
            }))
          });
          return function () {
            return n.apply(this, arguments)
          }
        }();
        t && e()
      }), [t]), (0, r.jsxs)(r.Fragment, {
        children: [(0, r.jsxs)("div", {
          className: ce()("w-full", {"opacity-50": s}),
          children: [(0, r.jsxs)("div", {
            className: "text-sm md:text-base font-medium text-darkgray-800 font-sans flex items-center justify-start",
            children: [!(0, ae.yV)(t) && (0, r.jsx)(Nn, {status: t.status}), bn()(t.address), s && (0, r.jsx)("span", {
              className: "text-xs font-sans text-white bg-red-400 rounded-md p-1 ml-1 mt-0.5 flex items-center justify-center",
              children: (0, r.jsx)(gi, {className: "w-3 h-3 text-white"})
            })]
          }), (0, r.jsxs)("div", {
            className: "flex items-center space-x-4 h-6 text-gray-525 text-xs md:text-sm whitespace-nowrap",
            children: [(0, r.jsx)(Zo, {rewardScale: null === t || void 0 === t ? void 0 : t.rewardScale}), (0, r.jsx)(Vo, {address: t.address})]
          })]
        }), (0, r.jsx)("div", {
          className: "flex flex-col items-center justify-center px-4",
          children: (0, r.jsx)("div", {
            className: "flex items-center",
            children: (0, r.jsx)("span", {
              className: "whitespace-nowrap text-xs md:text-sm font-sans text-gray-525",
              children: (0, r.jsx)(Ro, {hotspot: t})
            })
          })
        }), (0, r.jsx)("div", {
          className: "flex items-center",
          children: (0, r.jsx)("img", {alt: "", src: "/images/details-arrow.svg"})
        })]
      })
    }, Uo = function (e) {
      var t = e.hotspots, n = e.isLoading, s = void 0 === n || n, i = e.fetchMore, o = e.isLoadingMore, l = e.hasMore,
        c = e.title, u = e.description, d = e.showCount, f = (0, ee.Z)().selectHotspot,
        m = (0, a.useCallback)((function (e) {
          f(e.address)
        }), [f]), h = (0, a.useCallback)((function (e) {
          return e.address
        }), []), p = (0, a.useCallback)((function (e) {
          return "/hotspots/".concat(e.address)
        }), []), x = (0, a.useCallback)((function (e) {
          return (0, r.jsx)(Wo, {hotspot: e})
        }), []);
      return (0, r.jsx)(In, {
        items: t,
        listHeaderTitle: c,
        listHeaderShowCount: d,
        listHeaderDescription: u,
        keyExtractor: h,
        linkExtractor: p,
        onSelectItem: m,
        isLoading: s,
        renderItem: x,
        blankTitle: "No Hotspots",
        fetchMore: i,
        isLoadingMore: o,
        hasMore: l
      })
    }, zo = function () {
      var e = (0, i.UO)().index, t = (0, Qt.r5)(vn.qi, [e]), n = t.result, s = t.loading, o = (0, Le.Z)(e),
        l = o.selectedHex, c = o.selectHex, u = o.clearSelectedHex;
      (0, a.useEffect)((function () {
        l || c(e)
      }), [l, e, c]), (0, a.useEffect)((function () {
        return function () {
          u()
        }
      }), [u]);
      var d = (0, a.useCallback)((function (e) {
        return e ? [[{
          icon: (0, r.jsx)(de, {geocode: e.geocode, showLocationName: !1}),
          path: "/hotspots/cities/".concat(e.geocode.cityId),
          title: (0, ae.T7)(e.geocode)
        }]] : [[{iconPath: "/images/location-blue.svg", loading: !0}]]
      }), []);
      return (0, r.jsx)(pt, {
        title: (0, r.jsxs)("div", {
          className: "flex items-center justify-center",
          children: [(0, r.jsx)("img", {
            alt: "",
            src: "/images/location-hex.svg",
            className: "h-7 w-auto mr-0.5 md:mr-2"
          }), e]
        }),
        metaTitle: "Hex ".concat(e),
        breadcrumbs: [{title: "Hotspots", path: "/hotspots"}],
        subtitles: d(null === n || void 0 === n ? void 0 : n[0]),
        children: (0, r.jsx)(pn, {
          htmlTitleRoot: "Hex ".concat(e.slice(0, 5), "..."),
          children: (0, r.jsx)(hn, {
            title: "Hotspots",
            children: (0, r.jsx)("div", {
              className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
                "overflow-y-scroll": !s,
                "overflow-y-hidden": s
              }),
              children: (0, r.jsx)(Uo, {
                hotspots: n || [],
                isLoading: s,
                hasMore: !1,
                title: "Hotspots in Hex",
                showCount: !0
              })
            })
          }, "hotspots")
        })
      })
    }, Ko = n(55049), qo = n(313);

    function $o(e) {
      var t;
      if ("function" === typeof Symbol) {
        if (Symbol.asyncIterator && null != (t = e[Symbol.asyncIterator])) return t.call(e);
        if (Symbol.iterator && null != (t = e[Symbol.iterator])) return t.call(e)
      }
      throw new TypeError("Object is not async iterable")
    }

    function Jo(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    var Yo = function () {
      var e, t = (e = f().mark((function e() {
        var t, n, r, a, s, i, o, l, c, u;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              return t = (0, Ko.Z)(new Date, 30), n = [], e.next = 4, m.ZP.oracle.listPrices();
            case 4:
              r = e.sent, e.prev = 5, a = !1, s = !1, e.prev = 7, o = $o(r);
            case 9:
              return e.next = 11, o.next();
            case 11:
              if (!(a = !(l = e.sent).done)) {
                e.next = 20;
                break
              }
              if (c = l.value, u = c, !(0, qo.Z)(new Date(u.timestamp), t)) {
                e.next = 16;
                break
              }
              return e.abrupt("break", 20);
            case 16:
              n.push(u);
            case 17:
              a = !1, e.next = 9;
              break;
            case 20:
              e.next = 26;
              break;
            case 22:
              e.prev = 22, e.t0 = e.catch(7), s = !0, i = e.t0;
            case 26:
              if (e.prev = 26, e.prev = 27, !a || null == o.return) {
                e.next = 31;
                break
              }
              return e.next = 31, i.return();
            case 31:
              if (e.prev = 31, !s) {
                e.next = 34;
                break
              }
              throw i;
            case 34:
              return e.finish(31);
            case 35:
              return e.finish(26);
            case 36:
              e.next = 41;
              break;
            case 38:
              e.prev = 38, e.t1 = e.catch(5), console.error(e.t1);
            case 41:
              return e.abrupt("return", n);
            case 42:
            case"end":
              return e.stop()
          }
        }), e, null, [[5, 38], [7, 22, 26, 36], [27, , 31, 35]])
      })), function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            Jo(s, r, a, i, o, "next", e)
          }

          function o(e) {
            Jo(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      });
      return function () {
        return t.apply(this, arguments)
      }
    }();

    function Xo(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function Qo(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return Xo(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return Xo(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var el = function () {
      var e, t, n, a = zt().market, s = Jt().stats, i = function (e) {
        var t = (0, Rt.ZP)("latestOraclePrices", (function () {
          return Yo()
        }), {initialData: e, refreshInterval: 6e4}), n = t.data, r = t.error;
        return {oraclePrices: n, isLoading: !r && !n, isError: r}
      }().oraclePrices, o = Qo(i || [], 1)[0];
      (0, L.ZP)("/network/rewards").data;
      return (0, r.jsx)(pt, {
        title: "Market", metaTitle: "Market", children: (0, r.jsx)(pn, {
          htmlTitleRoot: "Market", children: (0, r.jsx)(hn, {
            title: "Statistics", children: (0, r.jsxs)(Dt, {
              children: [(0, r.jsx)(Tt, {
                title: "Oracle Price",
                tooltip: "Oracle price is used to determine how many DC are produced when burning HNT",
                series: null === (e = null === i || void 0 === i ? void 0 : i.map((function (e) {
                  return {value: e.price.floatBalance}
                }))) || void 0 === e ? void 0 : e.reverse(),
                locale: "en-US",
                toLocaleStringOpts: {
                  style: "currency",
                  currency: "USD",
                  minimumFractionDigits: 2,
                  maximumFractionDigits: 2
                },
                changeType: "percent",
                periodLabel: "30 Day Trend",
                isLoading: !i
              }), (0, r.jsx)(At, {
                title: "Market Price",
                tooltip: "Based on data provided by CoinGecko",
                value: (0, r.jsx)(Zt, {value: null === a || void 0 === a ? void 0 : a.price}),
                change: (0, c.round)(null === a || void 0 === a ? void 0 : a.priceChange, 2),
                changeSuffix: "%",
                isLoading: !a
              }), (0, r.jsx)(At, {
                title: "Market Cap",
                tooltip: "Based on data provided by CoinGecko",
                value: (0, r.jsx)(Zt, {
                  value: (null === a || void 0 === a ? void 0 : a.price) * (null === s || void 0 === s ? void 0 : s.circulatingSupply),
                  isLarge: !0
                }),
                subtitle: (0, r.jsxs)("span", {
                  className: "text-gray-550",
                  children: ["Vol: ", (0, r.jsx)(Zt, {
                    value: null === a || void 0 === a ? void 0 : a.volume,
                    isLarge: !0
                  })]
                }),
                isLoading: !a || !s
              }), (0, r.jsx)(At, {
                title: "Circulating Supply",
                tooltip: "".concat((0, c.round)(null === s || void 0 === s ? void 0 : s.circulatingSupply).toLocaleString(), " HNT currently in circulation"),
                value: "".concat((0, c.round)((null === s || void 0 === s ? void 0 : s.circulatingSupply) / 1e6, 3), "M"),
                subtitle: (0, r.jsx)("span", {className: "text-gray-550", children: "HNT"}),
                isLoading: !s
              }), (0, r.jsx)(At, {
                title: "Max Supply",
                tooltip: "There is an effective cap of 223M HNT due to reward halvings every 2 years",
                value: "223M",
                subtitle: (0, r.jsx)("span", {className: "text-gray-550", children: "HNT"})
              }), (0, r.jsx)(At, {
                title: "Data Credit Price",
                tooltip: "Data Credits are fixed at $0.00001 USD. Oracle price is used to compute how much HNT to burn.",
                value: "$0.00001",
                subtitle: (0, r.jsx)("span", {className: "text-gray-550", children: "fixed"})
              }), (0, r.jsx)(At, {
                title: "DC per HNT",
                tooltip: "DC are used to transmit or receive 24 bytes of data over the Helium Network",
                value: null === (n = null === o || void 0 === o || null === (t = o.price) || void 0 === t ? void 0 : t.toDataCredits()) || void 0 === n ? void 0 : n.toString(0, {showTicker: !1}),
                isLoading: !i
              }), (0, r.jsx)("div", {className: "col-span-2 pb-1"})]
            })
          }, "statistics")
        })
      })
    }, tl = function (e) {
      var t = e.tags;
      return (0, r.jsx)("div", {
        className: "flex items-center space-x-2",
        children: null === t || void 0 === t ? void 0 : t.map((function (e) {
          return (0, r.jsx)("div", {
            className: ce()("px-2 py-0.5 rounded-full text-xs font-medium"),
            style: {backgroundColor: e.backgroundColor, color: e.foregroundColor},
            children: e.label
          })
        }))
      })
    }, nl = function (e) {
      var t = e.title, n = e.description, a = e.tags, s = e.url;
      return (0, r.jsx)(At, {
        span: 2,
        title: (0, r.jsx)(tl, {tags: a}),
        value: t,
        subtitle: n,
        longSubtitle: !0,
        linkTo: s
      })
    }, rl = {
      monitoring: {label: "Monitoring", foregroundColor: "#474DFF", backgroundColor: "#d4d4ff"},
      export: {label: "Data Export", foregroundColor: "#A667F6", backgroundColor: "#e4d5fd"},
      ios: {label: "iOS", foregroundColor: "#32C48D", backgroundColor: "#ccf1e8"},
      android: {label: "Android", foregroundColor: "#FF4747", backgroundColor: "#f8d4d9"},
      planning: {label: "Planning", foregroundColor: "#F0BB32", backgroundColor: "#f7ebc6"}
    }, al = [{
      name: "Bobcat Diagnoser",
      url: "https://www.bobcatminer.com/post/bobcat-diagnoser-user-guide",
      description: "This utility reports miner temp, firmware updates, syncing blocks and more for Bobcat Hotspots.",
      tags: [rl.monitoring, rl.export]
    }, {
      name: "DeWi Rewards Report",
      url: "https://etl.dewi.org/dashboard/11-rewards-report-for-an-account",
      description: "A free rewards report for accounts to tabulate mining earnings.",
      tags: [rl.export]
    }, {
      name: "Fairspot CSV Export",
      url: "https://www.fairspot.host/hnt-export-mining-tax",
      description: "A tool to export transactions from your Helium wallet.",
      tags: [rl.export]
    }, {
      name: "HDS - Hotspot Discord Status",
      url: "https://www.github.com/co8/hds",
      description: "Activity and Reward Notifications sent to your Discord Channel",
      tags: [rl.monitoring]
    }, {
      name: "Helert",
      url: "https://helert.com",
      description: "Email alerts for new nearby hotspots, offline hotspots, transmit scale changes and more!",
      tags: [rl.monitoring]
    }, {
      name: "Helistats",
      url: "https://apps.apple.com/us/app/helistats/id1573119107",
      description: "Monitor your account and devices on your iOS devices, incl. widgets.",
      tags: [rl.monitoring, rl.ios]
    }, {
      name: "Helisum",
      url: "https://helisum.com",
      description: "Hotspot Monitoring and Dashboard solution",
      tags: [rl.monitoring, rl.export]
    }, {
      name: "Helium Geek",
      url: "https://heliumgeek.com",
      description: "Check your hotspot vitals and your rewards, get notified for network issues and rewards. HeliumGeek supports iOS, Android, iOS widgets and Apple Watch app with complications.",
      tags: [rl.monitoring, rl.android, rl.ios]
    }, {
      name: "Heliumbot.io",
      url: "https://heliumbot.io",
      description: "Managed hotspot monitoring and profit calculation service providing push notifications",
      tags: [rl.monitoring]
    }, {
      name: "Helium Hosts",
      url: "https://heliumhosts.com/",
      description: "Network with other Hotspot owners in your area",
      tags: [rl.planning]
    }, {
      name: "HeliumStatus.io",
      url: "https://app.heliumstatus.io",
      description: "Diagnostic tools and hotspot monitoring",
      tags: [rl.monitoring]
    }, {
      name: "helium-tax",
      url: "https://davetapley.com/helium-tax/",
      description: "Export CSV for mining and staking rewards",
      tags: [rl.export]
    }, {
      name: "helium.tools",
      url: "https://helium.tools",
      description: "Set of tools to monitor and compare earnings in selected location(s).",
      tags: [rl.planning, rl.monitoring]
    }, {
      name: "HeliumVision",
      url: "https://helium.vision",
      description: "Helium Network Planning, Optimization and Simulations",
      tags: [rl.monitoring, rl.planning]
    }, {
      name: "HMS Block Status Tool",
      url: "https://heliummining.se/check-my-block-status/",
      description: "Easily look up your Hotspot device block height, sync status, relay and more to track progress.",
      tags: [rl.monitoring]
    }, {
      name: "HNT-tracker",
      url: "https://hnt-tracker.fifu-verein.de/",
      description: "Free CSV exports for HNT rewards, balance and payments. Conversion into all major currencies. Useful for taxes.",
      tags: [rl.export]
    }, {
      name: "HNTMonitor",
      url: "https://www.hntmonitor.com/",
      description: "Monitor real-time and historical data with alerting. Useful for managing fleets of hotspots in a single ui.",
      tags: [rl.monitoring]
    }, {
      name: "Hotsbot",
      url: "https://hotsbot.net/",
      description: "Hotspot monitoring and event tracking via Telegram",
      tags: [rl.monitoring]
    }, {
      name: "Hotspot Utility",
      url: "https://apps.apple.com/us/app/helium-hotspot-utility/id1527367455",
      description: "This App allows you to easily configure your Hotspot WiFi and view Ethernet status.",
      tags: [rl.ios]
    }, {
      name: "HotspotRF",
      url: "https://hotspotrf.com",
      description: "Improve and optimize Helium hotspot placement using Radio Frequency (RF) modeling.",
      tags: [rl.planning]
    }, {
      name: "Hotspotty",
      url: "https://hotspotty.net",
      description: "Your all-in-one tool for building the Helium network",
      tags: [rl.monitoring, rl.export, rl.planning]
    }, {
      name: "Kudzu",
      url: "https://analytics.kudzu.gr/",
      description: "Advanced placement and monitoring tool",
      tags: [rl.monitoring, rl.planning]
    }, {
      name: "MinerTax",
      url: "https://www.minertax.com/home?symbol=HNT",
      description: "Export CSV for mining and staking rewards",
      tags: [rl.export]
    }, {
      name: "Nebra Dashboard",
      url: "https://dashboard.nebra.com",
      description: "Control and monitor your Nebra (and in future other branded) Hotspots remotely including host tools.",
      tags: [rl.monitoring]
    }, {
      name: "Nebra Diagnostics",
      url: "https://helium.nebra.com/handy-guides/local-diagnostics",
      description: "Local diagnostics utility for Nebra Hotspots including syncing, firmware, and other useful info.",
      tags: [rl.monitoring]
    }, {
      name: "SenseCAP Dashboard",
      url: "https://status.sensecapmx.cloud",
      description: "The diagnostic and reward statistics dashboard, for SenseCAP Hotspots.",
      tags: [rl.monitoring]
    }, {
      name: "TaxBit",
      url: "https://www.taxbit.com",
      description: "Simplifying Helium taxes and Data Aggregation for investors and miners",
      tags: [rl.export]
    }, {
      name: "ZenLedger",
      url: "https://www.zenledger.io",
      description: "Simplifying Helium taxes for investors and miners",
      tags: [rl.export]
    }, {
      name: "hntTax",
      url: "https://hnttax.us",
      description: "A tax firm specializing in HNT mining taxes. Offers both free and paid tax advice and services.",
      tags: [rl.export]
    }, {
      name: "Helium Portal",
      url: "https://heliumportal.com",
      description: "City and nationwide toplist and communication platform",
      tags: [rl.planning]
    }, {
      name: "HS Analyzer",
      url: "https://hs-analyzer.com",
      description: "HS Analyzer is simple tool for checking your Helium hotspot and its stats (RSSI, Valid / Invalid Beacons etc.).",
      tags: [rl.monitoring, rl.ios]
    }, {
      name: "DataGovs",
      url: "https://testflight.apple.com/join/8VZV1pxF",
      description: "DataGovs on Govs protocol lets teams and organizations buy, connect, automate, and monitor assets in one place\u2014Hotspots and sensors.",
      tags: [rl.monitoring]
    }, {
      name: "Helium Board",
      url: "https://www.heliumboard.com/",
      description: "Helium Board is a sophisticated tool for seeing reports for Helium hotspots and the overall Helium network, as well as receiving alerts for set triggers, and accessing multiple tools (PeerPing, PeerBook Inquiry, Hotspot Analysis etc.)",
      tags: [rl.monitoring, rl.planning]
    }, {
      name: "Watchium",
      url: "https://watchium.disk91.com",
      description: "Watch Helium hotspots, accurately. Monitor your fleet, export rewards. Built by miners. For miners. We have our own ETL/api distinct from Helium that makes the app very fast. Get an invitation code on our Discord channel #watchium",
      tags: [rl.monitoring, rl.export, rl.android, rl.ios]
    }], sl = function (e) {
      var t = e.children, n = e.className, a = e.defaultClasses, s = void 0 === a || a;
      return (0, r.jsx)("div", {
        className: ce()({"bg-white w-full px-4 py-2 border-b border-solid border-gray-400": s}, n),
        children: (0, r.jsx)("div", {className: ce()("flex items-center justify-between"), children: t})
      })
    };

    function il(e, t) {
      (null == t || t > e.length) && (t = e.length);
      for (var n = 0, r = new Array(t); n < t; n++) r[n] = e[n];
      return r
    }

    function ol(e, t) {
      return function (e) {
        if (Array.isArray(e)) return e
      }(e) || function (e, t) {
        var n = null == e ? null : "undefined" !== typeof Symbol && e[Symbol.iterator] || e["@@iterator"];
        if (null != n) {
          var r, a, s = [], i = !0, o = !1;
          try {
            for (n = n.call(e); !(i = (r = n.next()).done) && (s.push(r.value), !t || s.length !== t); i = !0) ;
          } catch (l) {
            o = !0, a = l
          } finally {
            try {
              i || null == n.return || n.return()
            } finally {
              if (o) throw a
            }
          }
          return s
        }
      }(e, t) || function (e, t) {
        if (!e) return;
        if ("string" === typeof e) return il(e, t);
        var n = Object.prototype.toString.call(e).slice(8, -1);
        "Object" === n && e.constructor && (n = e.constructor.name);
        if ("Map" === n || "Set" === n) return Array.from(n);
        if ("Arguments" === n || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)) return il(e, t)
      }(e, t) || function () {
        throw new TypeError("Invalid attempt to destructure non-iterable instance.\\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")
      }()
    }

    var ll = function () {
      var e = (0, a.useMemo)((function () {
          return al.sort((function (e, t) {
            return e.name.toLowerCase().localeCompare(t.name.toLowerCase())
          }))
        }), []), t = (0, a.useState)(e), n = t[0], s = t[1], i = (0, a.useState)(null), o = i[0], l = i[1],
        c = (0, a.useState)(""), u = c[0], d = c[1];
      return (0, a.useEffect)((function () {
        if ("" === u) s(e); else {
          var t = u.toLowerCase(), n = new x.Z(e, {
            includeScore: !0,
            keys: ["name", "description", "url", "tags.label"],
            minMatchCharLength: 1,
            threshold: .3
          }).search(t).map((function (e) {
            return e.item
          }));
          s(n)
        }
      }), [u, e]), (0, a.useEffect)((function () {
        if (null === o) s(e); else {
          var t = e.filter((function (e) {
            var t = null === e || void 0 === e ? void 0 : e.tags;
            return null === t || void 0 === t ? void 0 : t.some((function (e) {
              return (null === e || void 0 === e ? void 0 : e.label) === o
            }))
          }));
          s(t)
        }
      }), [o, e]), (0, r.jsxs)(pt, {
        title: "Community Tools",
        metaTitle: "Community Tools",
        children: [(0, r.jsx)(Pn, {
          title: "Community Tools",
          description: (0, r.jsxs)("div", {
            className: "flex flex-col space-y-2",
            children: [(0, r.jsx)("div", {children: "A set of tools that have been built by the Helium community. The tools listed are not endorsed by Helium Inc. or its core developers. Please use community tools at your own discretion."}), (0, r.jsxs)("div", {
              children: ["If there's a tool that isn't listed here that you think should be, you can", " ", (0, r.jsx)("a", {
                className: "text-navy-400 hover:text-navy-300",
                href: "https://github.com/helium/explorer/edit/v2/data/communitytools.js",
                rel: "noopener noreferrer",
                target: "_blank",
                children: "edit this file"
              }), ", then create a new branch and start a pull request against", " ", (0, r.jsx)("a", {
                className: "text-navy-400 hover:text-navy-300",
                href: "https://github.com/helium/explorer",
                rel: "noopener noreferrer",
                target: "_blank",
                children: "the v2 branch of the Helium Explorer GitHub repository"
              }), " ", "to add it."]
            })]
          })
        }), (0, r.jsx)(sl, {
          defaultClasses: !1,
          className: "pt-1 md:pt-2 px-1.5 md:px-4 border-b border-solid border-gray-350 bg-gray-300",
          children: (0, r.jsx)("div", {
            className: "flex flex-col w-full",
            children: (0, r.jsxs)("div", {
              className: "flex flex-row items-center justify-start flex-wrap",
              children: [Object.entries(rl).map((function (e) {
                var t = ol(e, 2), n = (t[0], t[1]);
                return (0, r.jsx)("div", {
                  className: "px-1 md:px-1.5 py-1 md:py-0.5 rounded-md md:rounded-lg text-xs md:text-sm font-sans mr-1 md:mr-1.5 cursor-pointer whitespace-nowrap mb-1 md:mb-2",
                  style: n.label === o ? {
                    backgroundColor: n.foregroundColor,
                    color: n.backgroundColor
                  } : {backgroundColor: n.backgroundColor, color: n.foregroundColor},
                  onClick: function () {
                    return function (e) {
                      d(""), l(o === e ? null : e)
                    }(n.label)
                  },
                  children: n.label
                })
              })), (0, r.jsx)("input", {
                type: "search",
                id: "filter-search",
                value: u,
                onChange: function (e) {
                  e.preventDefault(), null !== o && l(null), d(e.target.value)
                },
                className: "border border-solid border-gray-350 bg-white focus:border-gray-525 outline-none text-base font-light flex-grow font-sans w-20 rounded-lg px-1 mb-1 md:mb-2",
                placeholder: "or search...",
                autoComplete: "off"
              })]
            })
          })
        }), (0, r.jsxs)(Dt, {
          children: [n.map((function (e) {
            return (0, r.jsx)(nl, {tags: e.tags, title: e.name, description: e.description, url: e.url})
          })), 0 === n.length && (0, r.jsx)("span", {
            className: "text-gray-525 w-full text-center col-span-2",
            children: "No results"
          })]
        })]
      })
    }, cl = n(80129), ul = n.n(cl), dl = function (e) {
      var t = e.city;
      return t ? (0, r.jsxs)(Dt, {
        children: [(0, r.jsx)(At, {
          value: t.hotspotCount.toLocaleString(),
          title: "Total Hotspots in City",
          subtitle: "".concat((t.onlineCount / t.hotspotCount * 100).toLocaleString(void 0, {maximumFractionDigits: 2}), "% online"),
          span: 2
        }), (0, r.jsx)(At, {
          value: t.onlineCount.toLocaleString(),
          title: "Online Hotspots"
        }), (0, r.jsx)(At, {value: t.offlineCount.toLocaleString(), title: "Offline Hotspots"})]
      }) : (0, r.jsx)(xi, {})
    }, fl = function (e) {
      var t = e.city, n = (0, vn.vy)("city", null === t || void 0 === t ? void 0 : t.cityId), a = n.hotspots,
        s = n.fetchMore, i = n.isLoadingInitial, o = n.isLoadingMore, l = n.hasMore;
      return !t || i ? (0, r.jsx)(Cn, {}) : (0, r.jsx)("div", {
        className: ce()("grid grid-flow-row grid-cols-1 no-scrollbar", {
          "overflow-y-scroll": !i,
          "overflow-y-hidden": i
        }), children: (0, r.jsx)(rr, {hotspots: a, isLoading: i, isLoadingMore: o, fetchMore: s, hasMore: l})
      })
    };

    function ml(e, t, n, r, a, s, i) {
      try {
        var o = e[s](i), l = o.value
      } catch (c) {
        return void n(c)
      }
      o.done ? t(l) : Promise.resolve(l).then(r, a)
    }

    function hl(e, t, n) {
      return t in e ? Object.defineProperty(e, t, {
        value: n,
        enumerable: !0,
        configurable: !0,
        writable: !0
      }) : e[t] = n, e
    }

    function pl(e) {
      for (var t = 1; t < arguments.length; t++) {
        var n = null != arguments[t] ? arguments[t] : {}, r = Object.keys(n);
        "function" === typeof Object.getOwnPropertySymbols && (r = r.concat(Object.getOwnPropertySymbols(n).filter((function (e) {
          return Object.getOwnPropertyDescriptor(n, e).enumerable
        })))), r.forEach((function (t) {
          hl(e, t, n[t])
        }))
      }
      return e
    }

    var xl = function () {
      var e, t = (0, i.UO)().cityid, n = (0, Ce.Z)(), s = n.selectedCity, o = n.selectCity, l = n.clearSelectedCity,
        c = (0, a.useState)(!1), u = c[0], d = c[1];
      (0, Qt.r5)((e = f().mark((function e() {
        var n, r;
        return f().wrap((function (e) {
          for (; ;) switch (e.prev = e.next) {
            case 0:
              if (s) {
                e.next = 10;
                break
              }
              return d(!0), e.next = 4, m.ZP.cities.get(t);
            case 4:
              return n = e.sent, e.next = 7, (0, L.a8)("v1")("/cities/search?" + ul().stringify({term: [n.longCity, n.longState, n.longCountry].join(", ")}));
            case 7:
              r = e.sent, o(pl({}, n, {geometry: r})), d(!1);
            case 10:
            case"end":
              return e.stop()
          }
        }), e)
      })), function () {
        var t = this, n = arguments;
        return new Promise((function (r, a) {
          var s = e.apply(t, n);

          function i(e) {
            ml(s, r, a, i, o, "next", e)
          }

          function o(e) {
            ml(s, r, a, i, o, "throw", e)
          }

          i(void 0)
        }))
      }), [t, l, o, s]), (0, a.useEffect)((function () {
        return function () {
          l()
        }
      }), [l]);
      var h;
      return (0, r.jsx)(pt, {
        title: (h = s, h ? (0, r.jsx)("span", {
          className: "flex items-start justify-start",
          children: "".concat((null === h || void 0 === h ? void 0 : h.longCity) ? h.longCity : "").concat((null === h || void 0 === h ? void 0 : h.longState) && (null === h || void 0 === h ? void 0 : h.longCity) ? ", " : "").concat(null === h || void 0 === h ? void 0 : h.longState)
        }) : "Loading city..."),
        metaTitle: null === s || void 0 === s ? void 0 : s.longCity,
        breadcrumbs: [{title: "Hotspots", path: "/hotspots/latest"}, {title: "Cities", path: "/hotspots/cities"}],
        subtitles: function (e) {
          return e ? [[{
            title: s.longCountry,
            icon: (0, r.jsx)(oe.Z, {countryCode: s.shortCountry})
          }]] : [[{iconPath: "/images/location-blue.svg", loading: !0}]]
        }(s),
        children: (0, r.jsxs)(pn, {
          htmlTitleRoot: null === s || void 0 === s ? void 0 : s.longCity,
          children: [(0, r.jsx)(hn, {
            title: "Statistics",
            children: u ? (0, r.jsx)(xi, {}) : (0, r.jsx)(dl, {city: s})
          }, "statistics"), (0, r.jsx)(hn, {
            title: "Hotspots",
            path: "hotspots",
            children: u ? (0, r.jsx)(Cn, {}) : (0, r.jsx)(fl, {city: s})
          }, "hotspots")]
        })
      })
    }, vl = function () {
      var e = "/:locale(en|fr)?";
      return (0, r.jsxs)(i.rs, {
        children: [(0, r.jsx)(i.AW, {
          path: "".concat(e, "/hotspots/hex/:index([a-z0-9]{15})"),
          children: (0, r.jsx)(zo, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/hotspots/:address([a-zA-Z0-9]{40,})"),
          children: (0, r.jsx)(ki, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/hotspots/cities/:cityid"),
          children: (0, r.jsx)(xl, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/hotspots"),
          children: (0, r.jsx)(pr, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/accounts/:address([a-zA-Z0-9]{40,})"),
          children: (0, r.jsx)(Ao, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/accounts"),
          children: (0, r.jsx)(vo, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/validators/:address([a-zA-Z0-9]{40,})"),
          children: (0, r.jsx)(Fo, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/validators"),
          children: (0, r.jsx)(Zi, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/blocks/:block(\\d+)"),
          children: (0, r.jsx)(eo, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/txns/:hash"),
          children: (0, r.jsx)(io, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/blocks"),
          children: (0, r.jsx)(Wi, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/beacons"),
          children: (0, r.jsx)(ao, {})
        }), (0, r.jsx)(i.AW, {
          path: "".concat(e, "/market"),
          children: (0, r.jsx)(el, {})
        }), (0, r.jsx)(i.AW, {path: "".concat(e, "/tools"), children: (0, r.jsx)(ll, {})}), (0, r.jsx)(i.AW, {
          exact: !0,
          path: e,
          children: (0, r.jsx)(un, {})
        }), (0, r.jsx)(i.AW, {
          exact: !0,
          path: "".concat(e, "/coverage"),
          children: (0, r.jsx)(un, {})
        }), (0, r.jsx)(i.AW, {children: (0, r.jsx)(so, {})})]
      })
    }, gl = n(58244), yl = n(92235).supported();
    yl || console.error("WebGL was not able to initialize in your browser. Please try on another device or browser to enable the full functionality of the Helium Explorer.");
    var jl = (0, s.default)((function () {
      return Promise.all([n.e(634), n.e(897), n.e(920)]).then(n.bind(n, 80920))
    }), {
      loadableGenerated: {
        webpack: function () {
          return [80920]
        }
      }, ssr: !1, loading: function () {
        return (0, r.jsx)("div", {})
      }
    }), wl = function (e) {
      var t = e.coverageUrl;
      (0, gl.ZP)();
      var n = (0, i.k6)(), a = (0, i.TH)();
      return te({
        Escape: function () {
          n.push(a.pathname.split("/").slice(0, -1).join("/") || "/")
        }
      }), (0, r.jsxs)(tt, {
        children: [(0, r.jsx)(et.default, {
          children: (0, r.jsx)("link", {
            href: "https://api.mapbox.com/mapbox-gl-js/v2.3.0/mapbox-gl.css",
            rel: "stylesheet"
          })
        }), (0, r.jsx)(st.q, {
          children: (0, r.jsx)("title", {
            "data-react-helmet": "true",
            children: "Helium Explorer"
          })
        }), (0, r.jsx)(Ye, {activeNav: "coverage"}), yl && (0, r.jsx)(jl, {coverageUrl: t}), (0, r.jsx)(vl, {}), (0, r.jsx)(at, {})]
      })
    }, bl = wl
  }, 67014: function (e, t, n) {
    "use strict";
    var r = n(67294), a = n(80537);
    t.Z = function () {
      return (0, r.useContext)(a.h).dispatch
    }
  }, 14361: function (e, t, n) {
    "use strict";
    n.d(t, {
      c5: function () {
        return a
      }, Ri: function () {
        return s
      }, vp: function () {
        return i
      }, xm: function () {
        return o
      }
    });
    var r = n(45291), a = function (e) {
      if (0 === e.length) return [[0, 0], [0, 0]];
      var t = e[0].lng, n = e[0].lng, r = e[0].lat, a = e[0].lat;
      return e.map((function (e) {
        e.lng < t && (t = e.lng), e.lng > n && (n = e.lng), e.lat < r && (r = e.lat), e.lat > a && (a = e.lat)
      })), [[n, a], [t, r]]
    }, s = function (e) {
      var t = e.lat, n = e.lng, r = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : .01;
      return [{lat: t + r, lng: n}, {lat: t - r, lng: n}]
    }, i = n.n(r)().parse([], {Point: ["lat", "lng"]}), o = function (e, t, n, r) {
      var a = function (e) {
          return e * Math.PI / 180
        }, s = a(r - t), i = a(n - e),
        o = Math.sin(s / 2) * Math.sin(s / 2) + Math.cos(a(t)) * Math.cos(a(r)) * Math.sin(i / 2) * Math.sin(i / 2);
      return 6371 * (2 * Math.atan2(Math.sqrt(o), Math.sqrt(1 - o)))
    }
  }, 75992: function () {
  }, 24654: function () {
  }, 52361: function () {
  }, 94616: function () {
  }
}, function (e) {
  e.O(0, [714, 662, 78, 316, 570, 979, 774, 888, 179], (function () {
    return t = 78581, e(e.s = t);
    var t
  }));
  var t = e.O();
  _N_E = t
}]);
