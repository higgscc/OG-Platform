/*
 * Copyright 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 * Please see distribution for license.
 */
$.register_module({
    name: 'og.views.analytics2',
    dependencies: [],
    obj: function () {
        var routes = og.common.routes, module = this, view,
            main_selector = '.OG-layout-analytics-center', form;
        module.rules = {load: {route: '/', method: module.name + '.load'}};
        return view = {
            check_state: og.views.common.state.check.partial('/'),
            load: function (args) {
                $('.OG-masthead .og-analytics-beta').addClass('og-active');
                var new_page = false;
                form = og.analytics.form2({url_config:og.analytics.url.main()});
                view.check_state({args: args, conditions: [
                    {new_page: function () {new_page = true; og.analytics.containers.initialize();}}
                ]});
                og.analytics.resize();
                if (!new_page && !args.data && og.analytics.url.last.main) {
                    og.analytics.url.clear_main(), $(main_selector).html('');
                    if (!og.analytics.url.last.main) form = og.analytics.form2();
                }
            },
            load_item: function (args) {
                view.check_state({args: args, conditions: [{new_page: view.load}]});
                og.analytics.url.process(args, function () {
                    form = og.analytics.form2({url_config:og.analytics.url.main()});
                });
            },
            init: function () {for (var rule in view.rules) routes.add(view.rules[rule]);},
            rules: {
                load: {route: '/', method: module.name + '.load'},
                load_item: {route: '/:data', method: module.name + '.load_item'}
            }
        };
    }
});