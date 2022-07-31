//
//  Configuration.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 31.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

class Configuration {

    static func value<T>(defaultValue: T, forKey key: String) -> T {
        let preferences = UserDefaults.standard
        return preferences.object(forKey: key) == nil ? defaultValue : preferences.object(forKey: key) as! T
    }

    static func value(value: Any, forKey key: String) {
        UserDefaults.standard.set(value, forKey: key)
    }

}
