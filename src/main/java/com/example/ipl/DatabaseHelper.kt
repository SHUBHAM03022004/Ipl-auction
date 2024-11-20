package com.example.ipl

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "IPLApp.db"
        const val DATABASE_VERSION = 2

        // Table Names
        const val TABLE_USERS = "Users"
        const val TABLE_PLAYERS = "Players"
        const val TABLE_TEAMS = "Teams"
        const val TABLE_BIDS = "Bids"

        // Users Table Columns
        const val COLUMN_USERNAME = "username"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD = "password"

        // Players Table Columns
        const val COLUMN_PLAYER_ID = "player_id"
        const val COLUMN_PLAYER_NAME = "player_name"
        const val COLUMN_PLAYER_ROLE = "role"
        const val COLUMN_PLAYER_PRICE = "price"
        const val COLUMN_PLAYER_TEAM = "team"
        const val COLUMN_PLAYER_AGE = "age"

        // Teams Table Columns
        const val COLUMN_TEAM_NAME = "team_name"
        const val COLUMN_TEAM_OWNER = "team_owner"

        // Bids Table Columns
        const val COLUMN_BID_PLAYER_ID = "player_id"
        const val COLUMN_BID_USER = "username"
        const val COLUMN_BID_AMOUNT = "amount"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Create Users Table
        val createUsersTable = """
            CREATE TABLE $TABLE_USERS (
                $COLUMN_USERNAME TEXT PRIMARY KEY,
                $COLUMN_EMAIL TEXT NOT NULL,
                $COLUMN_PASSWORD TEXT NOT NULL
            )
        """
        db?.execSQL(createUsersTable)

        // Create Teams Table
        val createTeamsTable = """
            CREATE TABLE $TABLE_TEAMS (
                $COLUMN_TEAM_NAME TEXT PRIMARY KEY,
                $COLUMN_TEAM_OWNER TEXT NOT NULL
            )
        """
        db?.execSQL(createTeamsTable)



        val createPlayersTable = """
            CREATE TABLE $TABLE_PLAYERS (
                $COLUMN_PLAYER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_PLAYER_NAME TEXT NOT NULL,
                $COLUMN_PLAYER_ROLE TEXT NOT NULL,
                $COLUMN_PLAYER_AGE INTEGER NOT NULL,
                $COLUMN_PLAYER_PRICE INTEGER NOT NULL
                        
            )
        """
        db?.execSQL(createPlayersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_BIDS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TEAMS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PLAYERS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    // Insert a new user into the Users table
    fun insertUser(username: String, email: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_USERNAME, username)
            put(COLUMN_EMAIL, email)
            put(COLUMN_PASSWORD, password)
        }
        return db.insert(TABLE_USERS, null, values)
    }

    // Authenticate a user
    fun authenticateUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor: Cursor = db.query(
            TABLE_USERS,
            arrayOf(COLUMN_USERNAME),
            "$COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?",
            arrayOf(username, password),
            null,
            null,
            null
        )
        val isValidUser = cursor.count > 0
        cursor.close()
        return isValidUser
    }

    // Insert a new player into the Players table


    // Insert a new player into the Players table
    fun insertPlayer(playerName: String, role: String, age: Int, price: Int): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_PLAYER_NAME, playerName)
            put(COLUMN_PLAYER_ROLE, role)
            put(COLUMN_PLAYER_AGE, age)
            put(COLUMN_PLAYER_PRICE, price)
        }
        val result = db.insert(TABLE_PLAYERS, null, values)
        db.close()
        return result
    }



    // Get all players from the Players table
    // Method to get all players from the database
//    fun getAllPlayers(): Cursor {
//        val db = this.readableDatabase
//        return db.query(
//            TABLE_PLAYERS,
//            null,
//            null,
//            null,
//            null,
//            null,
//            null
//        )
//    }

    fun getAllPlayers(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_PLAYERS", null)
    }




















}
