/*
 * Copyright (C) 2016 Language Technology Group and Interactive Graphics Systems Group, Technische Universität Darmstadt, Germany
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Created by flo on 6/10/16.
 */


define([
    'angular',
    'angularMoment',
    'jquery-json',
    'ui-bootstrap',
    'ngAnimate',
    'ngFileSaver',
    'bootstrapFileField'
], function(angular) {
    'use strict';

    angular.module("myApp.history", ['ngFileSaver', 'ui.bootstrap','ngAnimate', 'bootstrap.fileField'])
        .config(function($uibTooltipProvider) {
        })
        .factory('historyFactory', [
            function() {
                return {
                    icons: {
                        'entity' : 'filter',
                        'metadata': 'filter',
                        'time': 'time',
                        "expandNode": 'plus',
                        "collapseNode": 'plus',
                        "egoNetwork": 'asterisk',
                        "merge": 'resize-small',
                        "hide": 'eye-close',
                        "edit": 'pencil',
                        "annotate": 'comment',
                        "fulltext": 'search',
                        "delete": 'remove',
                        "openDoc": 'book'
                    },
                    typeDescriptions: {
                      'entity': 'Entity Filter',
                      'metadata': 'Metadata Filter',
                      'time': 'Time Range',
                      'annotate': 'Entity Annotated',
                      'fulltext': 'Fulltext Search',
                      'openDoc': 'Document opened',
                      'edit': "Entity edited"
                    },
                    actions: {
                        'added': 'plus',
                        'removed': 'minus',
                        'replaced': 'refresh'
                    },
                    popover: {
                        template: 'tooltip_tmpl',
                        placement: 'bottom',
                        trigger: 'None',
                        isOpen: [],
                        promises: []
                    }
                }
            }
        ])
        .controller('HistoryController',
            [
                '$scope',
                '$timeout',
                'FileSaver',
                'ObserverService',
                'historyFactory',
                function ($scope, $timeout, FileSaver, ObserverService, historyFactory) {
                    $scope.observer = ObserverService;
                    $scope.factory = historyFactory;

                    $scope.observer_subscribe = function(history) { $scope.history = history};
                    $scope.observer_subscribe_items = function(items) { $scope.historyItems = items};
                    $scope.observer.subscribeHistory($scope.observer_subscribe);
                    $scope.observer.subscribeAllItems($scope.observer_subscribe_items);
                    $scope.removeItem = function(item) {
                        $scope.observer.removeItem(item.id, item.type);
                    };

                    $scope.getIcon = function(type) {
                        return $scope.factory.icons[type];
                    };

                    $scope.getActionIcon = function(type) {
                        return $scope.factory.actions[type];
                    };

                    $scope.removeItem = function(filter) {
                        $scope.observer.removeItem(filter.id, filter.type);
                    };

                    $scope.hidePopover = function(id) {
                        $scope.factory.popover.promises[id] = $timeout(function() { $scope.hideFunction(id)}, 500);
                    };

                    $scope.showPopover = function(id) {
                        if($scope.factory.popover.promises[id] != undefined) $timeout.cancel($scope.factory.popover.promises[id]);
                        $scope.factory.popover.isOpen[id] = true;
                    };

                    $scope.hideFunction = function(x) {
                        $scope.factory.popover.isOpen[x] = false;
                    };

                    $scope.getTypeDescription = function(x) {
                        return $scope.factory.typeDescriptions[x];
                    };

                    $scope.setFilterState = function() {
                        //FileSaver.saveAs(new Blob([$.toJSON(savedata)], {type: 'text/plain;charset=UTF-8'}), "filters_" + Date.now() + ".txt")
                    };

                    $scope.saveHistory =  function() {
                        console.log("save state");
                        var json = JSON.stringify({
                            history: $scope.history,
                            items: $scope.historyItems
                        },null, 4);
                        var data = new Blob([json],
                        { type: 'application/json;charset=utf-8' });
                        FileSaver.saveAs(data, "saver.json");
                    };

                    $scope.loadHistory = function() {
                        console.log("load state");
                        $scope.reader  = new FileReader();
                        $scope.reader.onload = function(){
                            $scope.observer.loadState(jQuery.parseJSON(angular.copy($scope.reader.result)));
                            $scope.uploadFile = undefined;
                        };
                        $scope.waitForFile = setInterval(function() {
                            if($scope.uploadFile) {
                                clearInterval($scope.waitForFile);
                                $scope.reader.readAsText($scope.uploadFile);
                            }
                        }, 500);

                    }
                }
            ]
        )
});