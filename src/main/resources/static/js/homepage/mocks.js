/**
 * Created by leens on 8/30/2016.
 */
define('mocks', ['jquery', 'mockjax'], function($) {
    var mocks = {};
    mocks.initMocks = function () {
        $.mockjax([
            {
                url: "http://api.openweathermap.org/data/2.5/weather?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831",
                responseText: {
                    "coord": {
                        "lon": -122.05,
                        "lat": 47.39
                    },
                    "weather": [
                        {
                            "id": 800,
                            "main": "Clear",
                            "description": "clear sky",
                            "icon": "01d"
                        }
                    ],
                    "base": "stations",
                    "main": {
                        "temp": 300.42,
                        "pressure": 1016.3,
                        "humidity": 43,
                        "temp_min": 298.71,
                        "temp_max": 301.15
                    },
                    "wind": {
                        "speed": 1.11,
                        "deg": 315.501
                    },
                    "clouds": {
                        "all": 0
                    },
                    "dt": 1471304186,
                    "sys": {
                        "type": 3,
                        "id": 1442728375,
                        "message": 0.0414,
                        "country": "US",
                        "sunrise": 1471266398,
                        "sunset": 1471317425
                    },
                    "id": 5802340,
                    "name": "Maple Valley",
                    "cod": 200
                },
                responseTime: [250, 750],
                onAfterComplete: function () {
                    console.log('Mockjax intercepted the request.');
                }
            },
            {
                url: "http://api.openweathermap.org/data/2.5/forecast/city?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831",
                responseText: {
                    "city": {
                        "id": 5802340,
                        "name": "Maple Valley",
                        "coord": {
                            "lon": -122.04641,
                            "lat": 47.392719
                        },
                        "country": "US",
                        "population": 0,
                        "sys": {
                            "population": 0
                        }
                    },
                    "cod": "200",
                    "message": 0.0435,
                    "cnt": 40,
                    "list": [
                        {
                            "dt": 1471305600,
                            "main": {
                                "temp": 299.43,
                                "temp_min": 296.95,
                                "temp_max": 299.43,
                                "pressure": 964.09,
                                "sea_level": 1030.18,
                                "grnd_level": 964.09,
                                "humidity": 52,
                                "temp_kf": 2.48
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.11,
                                "deg": 315.501
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-16 00:00:00"
                        },
                        {
                            "dt": 1471316400,
                            "main": {
                                "temp": 294.9,
                                "temp_min": 293.044,
                                "temp_max": 294.9,
                                "pressure": 964.22,
                                "sea_level": 1030.39,
                                "grnd_level": 964.22,
                                "humidity": 68,
                                "temp_kf": 1.86
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.76,
                                "deg": 313.001
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-16 03:00:00"
                        },
                        {
                            "dt": 1471327200,
                            "main": {
                                "temp": 289.55,
                                "temp_min": 288.308,
                                "temp_max": 289.55,
                                "pressure": 964.64,
                                "sea_level": 1031.23,
                                "grnd_level": 964.64,
                                "humidity": 87,
                                "temp_kf": 1.24
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.46,
                                "deg": 105.009
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-16 06:00:00"
                        },
                        {
                            "dt": 1471338000,
                            "main": {
                                "temp": 287,
                                "temp_min": 286.382,
                                "temp_max": 287,
                                "pressure": 964.64,
                                "sea_level": 1031.54,
                                "grnd_level": 964.64,
                                "humidity": 90,
                                "temp_kf": 0.62
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.76,
                                "deg": 150.005
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-16 09:00:00"
                        },
                        {
                            "dt": 1471348800,
                            "main": {
                                "temp": 285.231,
                                "temp_min": 285.231,
                                "temp_max": 285.231,
                                "pressure": 964.92,
                                "sea_level": 1032.01,
                                "grnd_level": 964.92,
                                "humidity": 92,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.66,
                                "deg": 185.501
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-16 12:00:00"
                        },
                        {
                            "dt": 1471359600,
                            "main": {
                                "temp": 288.5,
                                "temp_min": 288.5,
                                "temp_max": 288.5,
                                "pressure": 965.43,
                                "sea_level": 1032.56,
                                "grnd_level": 965.43,
                                "humidity": 84,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.7,
                                "deg": 180.001
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-16 15:00:00"
                        },
                        {
                            "dt": 1471370400,
                            "main": {
                                "temp": 294.455,
                                "temp_min": 294.455,
                                "temp_max": 294.455,
                                "pressure": 965.3,
                                "sea_level": 1031.92,
                                "grnd_level": 965.3,
                                "humidity": 66,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.17,
                                "deg": 301.001
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-16 18:00:00"
                        },
                        {
                            "dt": 1471381200,
                            "main": {
                                "temp": 297.549,
                                "temp_min": 297.549,
                                "temp_max": 297.549,
                                "pressure": 964.84,
                                "sea_level": 1031.08,
                                "grnd_level": 964.84,
                                "humidity": 57,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.2,
                                "deg": 313.509
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-16 21:00:00"
                        },
                        {
                            "dt": 1471392000,
                            "main": {
                                "temp": 297.43,
                                "temp_min": 297.43,
                                "temp_max": 297.43,
                                "pressure": 964.63,
                                "sea_level": 1030.63,
                                "grnd_level": 964.63,
                                "humidity": 58,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.16,
                                "deg": 319.507
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-17 00:00:00"
                        },
                        {
                            "dt": 1471402800,
                            "main": {
                                "temp": 293.803,
                                "temp_min": 293.803,
                                "temp_max": 293.803,
                                "pressure": 964.57,
                                "sea_level": 1030.82,
                                "grnd_level": 964.57,
                                "humidity": 71,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.89,
                                "deg": 320.501
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-17 03:00:00"
                        },
                        {
                            "dt": 1471413600,
                            "main": {
                                "temp": 289.118,
                                "temp_min": 289.118,
                                "temp_max": 289.118,
                                "pressure": 965.02,
                                "sea_level": 1031.67,
                                "grnd_level": 965.02,
                                "humidity": 92,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.76,
                                "deg": 325.503
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-17 06:00:00"
                        },
                        {
                            "dt": 1471424400,
                            "main": {
                                "temp": 287.111,
                                "temp_min": 287.111,
                                "temp_max": 287.111,
                                "pressure": 965,
                                "sea_level": 1031.94,
                                "grnd_level": 965,
                                "humidity": 95,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.67,
                                "deg": 128.003
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-17 09:00:00"
                        },
                        {
                            "dt": 1471435200,
                            "main": {
                                "temp": 285.903,
                                "temp_min": 285.903,
                                "temp_max": 285.903,
                                "pressure": 965.18,
                                "sea_level": 1032.23,
                                "grnd_level": 965.18,
                                "humidity": 96,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.71,
                                "deg": 183.501
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-17 12:00:00"
                        },
                        {
                            "dt": 1471446000,
                            "main": {
                                "temp": 288.739,
                                "temp_min": 288.739,
                                "temp_max": 288.739,
                                "pressure": 965.4,
                                "sea_level": 1032.57,
                                "grnd_level": 965.4,
                                "humidity": 90,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.71,
                                "deg": 163.501
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-17 15:00:00"
                        },
                        {
                            "dt": 1471456800,
                            "main": {
                                "temp": 294.342,
                                "temp_min": 294.342,
                                "temp_max": 294.342,
                                "pressure": 965.2,
                                "sea_level": 1031.93,
                                "grnd_level": 965.2,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.16,
                                "deg": 301.505
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-17 18:00:00"
                        },
                        {
                            "dt": 1471467600,
                            "main": {
                                "temp": 297.141,
                                "temp_min": 297.141,
                                "temp_max": 297.141,
                                "pressure": 964.71,
                                "sea_level": 1030.93,
                                "grnd_level": 964.71,
                                "humidity": 59,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.21,
                                "deg": 317.001
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-17 21:00:00"
                        },
                        {
                            "dt": 1471478400,
                            "main": {
                                "temp": 297.002,
                                "temp_min": 297.002,
                                "temp_max": 297.002,
                                "pressure": 964.29,
                                "sea_level": 1030.36,
                                "grnd_level": 964.29,
                                "humidity": 57,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.32,
                                "deg": 324.002
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-18 00:00:00"
                        },
                        {
                            "dt": 1471489200,
                            "main": {
                                "temp": 293.142,
                                "temp_min": 293.142,
                                "temp_max": 293.142,
                                "pressure": 964.19,
                                "sea_level": 1030.53,
                                "grnd_level": 964.19,
                                "humidity": 69,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.9,
                                "deg": 315.002
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-18 03:00:00"
                        },
                        {
                            "dt": 1471500000,
                            "main": {
                                "temp": 288.208,
                                "temp_min": 288.208,
                                "temp_max": 288.208,
                                "pressure": 964.56,
                                "sea_level": 1031.3,
                                "grnd_level": 964.56,
                                "humidity": 89,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.72,
                                "deg": 46.0017
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-18 06:00:00"
                        },
                        {
                            "dt": 1471510800,
                            "main": {
                                "temp": 286.437,
                                "temp_min": 286.437,
                                "temp_max": 286.437,
                                "pressure": 964.26,
                                "sea_level": 1031.19,
                                "grnd_level": 964.26,
                                "humidity": 95,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.78,
                                "deg": 117.501
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-18 09:00:00"
                        },
                        {
                            "dt": 1471521600,
                            "main": {
                                "temp": 285.602,
                                "temp_min": 285.602,
                                "temp_max": 285.602,
                                "pressure": 964.01,
                                "sea_level": 1031.16,
                                "grnd_level": 964.01,
                                "humidity": 95,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.81,
                                "deg": 104.503
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-18 12:00:00"
                        },
                        {
                            "dt": 1471532400,
                            "main": {
                                "temp": 289.099,
                                "temp_min": 289.099,
                                "temp_max": 289.099,
                                "pressure": 964.33,
                                "sea_level": 1031.49,
                                "grnd_level": 964.33,
                                "humidity": 85,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.97,
                                "deg": 116
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-18 15:00:00"
                        },
                        {
                            "dt": 1471543200,
                            "main": {
                                "temp": 296.137,
                                "temp_min": 296.137,
                                "temp_max": 296.137,
                                "pressure": 964.38,
                                "sea_level": 1031.06,
                                "grnd_level": 964.38,
                                "humidity": 64,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.22,
                                "deg": 330.5
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-18 18:00:00"
                        },
                        {
                            "dt": 1471554000,
                            "main": {
                                "temp": 299.746,
                                "temp_min": 299.746,
                                "temp_max": 299.746,
                                "pressure": 963.71,
                                "sea_level": 1029.94,
                                "grnd_level": 963.71,
                                "humidity": 56,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.2,
                                "deg": 321.507
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-18 21:00:00"
                        },
                        {
                            "dt": 1471564800,
                            "main": {
                                "temp": 299.803,
                                "temp_min": 299.803,
                                "temp_max": 299.803,
                                "pressure": 963.15,
                                "sea_level": 1029.12,
                                "grnd_level": 963.15,
                                "humidity": 56,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.21,
                                "deg": 324.506
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-19 00:00:00"
                        },
                        {
                            "dt": 1471575600,
                            "main": {
                                "temp": 295.522,
                                "temp_min": 295.522,
                                "temp_max": 295.522,
                                "pressure": 963.18,
                                "sea_level": 1029.31,
                                "grnd_level": 963.18,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.01,
                                "deg": 326.007
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-19 03:00:00"
                        },
                        {
                            "dt": 1471586400,
                            "main": {
                                "temp": 290.649,
                                "temp_min": 290.649,
                                "temp_max": 290.649,
                                "pressure": 963.76,
                                "sea_level": 1030.2,
                                "grnd_level": 963.76,
                                "humidity": 90,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.76,
                                "deg": 48.0019
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-19 06:00:00"
                        },
                        {
                            "dt": 1471597200,
                            "main": {
                                "temp": 289.249,
                                "temp_min": 289.249,
                                "temp_max": 289.249,
                                "pressure": 963.62,
                                "sea_level": 1030.3,
                                "grnd_level": 963.62,
                                "humidity": 84,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.95,
                                "deg": 88.0014
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-19 09:00:00"
                        },
                        {
                            "dt": 1471608000,
                            "main": {
                                "temp": 288.468,
                                "temp_min": 288.468,
                                "temp_max": 288.468,
                                "pressure": 963.28,
                                "sea_level": 1030.21,
                                "grnd_level": 963.28,
                                "humidity": 55,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.22,
                                "deg": 95.0019
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-19 12:00:00"
                        },
                        {
                            "dt": 1471618800,
                            "main": {
                                "temp": 290.996,
                                "temp_min": 290.996,
                                "temp_max": 290.996,
                                "pressure": 963.53,
                                "sea_level": 1030.44,
                                "grnd_level": 963.53,
                                "humidity": 75,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.92,
                                "deg": 87.0003
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-19 15:00:00"
                        },
                        {
                            "dt": 1471629600,
                            "main": {
                                "temp": 298.424,
                                "temp_min": 298.424,
                                "temp_max": 298.424,
                                "pressure": 963.42,
                                "sea_level": 1029.97,
                                "grnd_level": 963.42,
                                "humidity": 50,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.02,
                                "deg": 62.5013
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-19 18:00:00"
                        },
                        {
                            "dt": 1471640400,
                            "main": {
                                "temp": 301.552,
                                "temp_min": 301.552,
                                "temp_max": 301.552,
                                "pressure": 962.36,
                                "sea_level": 1028.43,
                                "grnd_level": 962.36,
                                "humidity": 39,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.22,
                                "deg": 339.503
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-19 21:00:00"
                        },
                        {
                            "dt": 1471651200,
                            "main": {
                                "temp": 300.717,
                                "temp_min": 300.717,
                                "temp_max": 300.717,
                                "pressure": 960.92,
                                "sea_level": 1026.7,
                                "grnd_level": 960.92,
                                "humidity": 41,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.29,
                                "deg": 328.501
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-20 00:00:00"
                        },
                        {
                            "dt": 1471662000,
                            "main": {
                                "temp": 295.306,
                                "temp_min": 295.306,
                                "temp_max": 295.306,
                                "pressure": 960.11,
                                "sea_level": 1026.06,
                                "grnd_level": 960.11,
                                "humidity": 63,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.89,
                                "deg": 318.004
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-20 03:00:00"
                        },
                        {
                            "dt": 1471672800,
                            "main": {
                                "temp": 290.01,
                                "temp_min": 290.01,
                                "temp_max": 290.01,
                                "pressure": 959.86,
                                "sea_level": 1026.08,
                                "grnd_level": 959.86,
                                "humidity": 83,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.66,
                                "deg": 67.5001
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-20 06:00:00"
                        },
                        {
                            "dt": 1471683600,
                            "main": {
                                "temp": 288.294,
                                "temp_min": 288.294,
                                "temp_max": 288.294,
                                "pressure": 959.12,
                                "sea_level": 1025.48,
                                "grnd_level": 959.12,
                                "humidity": 79,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 1.13,
                                "deg": 113.5
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-20 09:00:00"
                        },
                        {
                            "dt": 1471694400,
                            "main": {
                                "temp": 288.072,
                                "temp_min": 288.072,
                                "temp_max": 288.072,
                                "pressure": 958.62,
                                "sea_level": 1025.2,
                                "grnd_level": 958.62,
                                "humidity": 75,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.93,
                                "deg": 123.504
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2016-08-20 12:00:00"
                        },
                        {
                            "dt": 1471705200,
                            "main": {
                                "temp": 290.835,
                                "temp_min": 290.835,
                                "temp_max": 290.835,
                                "pressure": 958.68,
                                "sea_level": 1025.17,
                                "grnd_level": 958.68,
                                "humidity": 76,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.89,
                                "deg": 124.001
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-20 15:00:00"
                        },
                        {
                            "dt": 1471716000,
                            "main": {
                                "temp": 298.393,
                                "temp_min": 298.393,
                                "temp_max": 298.393,
                                "pressure": 958.52,
                                "sea_level": 1024.67,
                                "grnd_level": 958.52,
                                "humidity": 51,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.86,
                                "deg": 350.508
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-20 18:00:00"
                        },
                        {
                            "dt": 1471726800,
                            "main": {
                                "temp": 301.333,
                                "temp_min": 301.333,
                                "temp_max": 301.333,
                                "pressure": 957.69,
                                "sea_level": 1023.47,
                                "grnd_level": 957.69,
                                "humidity": 46,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 0.96,
                                "deg": 314.505
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2016-08-20 21:00:00"
                        }
                    ]
                },
                responseTime: [250, 750],
                onAfterComplete: function () {
                    console.log('Mockjax intercepted the request.');
                }
            }
        ]);
    };

    return mocks;
});