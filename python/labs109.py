import statistics
from fractions import Fraction

# As an example, here is an implementation of
# the first problem "Ryerson Letter Grade":


def ryerson_letter_grade(n):
    if n < 50:
        return "F"
    elif n > 89:
        return "A+"
    elif n > 84:
        return "A"
    elif n > 79:
        return "A-"
    tens = n // 10
    ones = n % 10
    if ones < 3:
        adjust = "-"
    elif ones > 6:
        adjust = "+"
    else:
        adjust = ""
    return "DCB"[tens - 5] + adjust


# Ascending list


def is_ascending(items):
    if len(items) <= 1:
        return True

    for i in range(0, len(items) - 1):
        if items[i + 1] > items[i]:
            next
        else:
            return False

    return True


# Riffle shuffle kerfuffl


def riffle(items, out=True):
    items_len = len(items)
    if items_len == 0:
        return []

    items1 = items[: items_len // 2]
    items2 = items[items_len // 2 :]

    if out:
        items_shuffled = zip(items1, items2)
    else:
        items_shuffled = zip(items2, items1)

    result = []
    for a, b in items_shuffled:
        result.append(a)
        result.append(b)

    return result


# Even the odds


def only_odd_digits(n):
    lowest_digit = n % 10
    if lowest_digit % 2 == 0:
        return False
    else:
        rest_of_digits = n // 10
        if rest_of_digits == 0:
            return True
        return only_odd_digits(rest_of_digits)


# Cyclops numbers


def is_cyclops(n):
    n_str = str(n)
    len_of_n = len(n_str)
    if len_of_n % 2 == 0:
        return False

    if n_str[len_of_n // 2] != "0":
        return False

    n_without_middle = n_str[: len_of_n // 2] + n_str[(len_of_n // 2) + 1 :]

    for m in n_without_middle:
        if m == "0":
            return False

    return True


# Domino cycle


def domino_cycle(tiles):
    if len(tiles) == 0:
        return True

    tiles_list = [item for t in tiles for item in t]
    if tiles_list[0] != tiles_list[-1]:
        return False

    tiles_list = tiles_list[1:-1]
    for i in range(0, len(tiles_list) - 1, 2):
        if tiles_list[i] != tiles_list[i + 1]:
            return False

    return True


# Colour trio


def colour_trio(colours):
    mixing = {
        "ry": "b",
        "rb": "y",
        "rr": "r",
        "yr": "b",
        "yb": "r",
        "yy": "y",
        "br": "y",
        "by": "r",
        "bb": "b",
    }
    c = len(colours)
    colors = colours
    while c > 1:
        result = [mixing[colors[i] + colors[i + 1]] for i in range(len(colors) - 1)]
        c -= 1
        colors = "".join(result)
    return colors


# Count dominators


def count_dominators(items):
    items_length = len(items)
    if items_length == 0:
        return 0

    count = 0

    item_max = items[-1]
    for i in range(items_length - 1, -1, -1):
        if items[i] > item_max:
            count += 1
            item_max = items[i]
    else:
        count += 1

    return count


# Beat the previous


def extract_increasing(digits):
    result = []
    current_number = 0
    previous_number = -1
    for d in digits:
        current_number = 10 * current_number + int(d)
        if current_number > previous_number:
            previous_number = current_number
            current_number = 0
            result.append(previous_number)
    return result


# Iterated ordinal transform


def to_ordinal(seq):
    seq_count = {}
    ordinal_transformed = []
    for s in seq:
        seq_count.setdefault(s, 0)
        seq_count[s] += 1
        ordinal_transformed.append(seq_count[s])
    return ordinal_transformed


def ordinal_transform(seed, i):
    result = []
    result.extend(seed)
    while len(result) <= i:
        seq = to_ordinal(result)
        result.extend(seq)

    return result[i]


# Subsequent words


def words_with_letters(words, letters):
    result = []
    letters_length = len(letters)
    for w in words:
        if len(w) >= letters_length:
            word_iter = iter(w)
            if all(l in word_iter for l in letters):
                result.append(w)
    # result = [w for w in words if all(l in iter(w) for l in letters)]
    return result


# Taxi Zum Zum


def taxi_zum_zum(moves):
    x = 0
    y = 0
    direction = "n"
    for m in moves:
        if m == "L":
            if direction == "e":
                direction = "n"
            elif direction == "w":
                direction = "s"
            elif direction == "n":
                direction = "w"
            elif direction == "s":
                direction = "e"
        elif m == "R":
            if direction == "e":
                direction = "s"
            elif direction == "w":
                direction = "n"
            elif direction == "n":
                direction = "e"
            elif direction == "s":
                direction = "w"
        elif m == "F":
            if direction == "e":
                x += 1
            elif direction == "w":
                x -= 1
            elif direction == "n":
                y += 1
            elif direction == "s":
                y -= 1
    return (x, y)


# Exact change only


def give_change(amount, coins):

    results = []
    for denomination in coins:
        if amount < denomination:
            continue
        remainder = amount % denomination
        if remainder == 0:
            results.extend([denomination] * (amount // denomination))
            break
        else:
            results.extend([denomination] * ((amount - remainder) // denomination))
            amount = remainder
    return results


# Rooks on a rampage


def safe_squares_rooks(n, rooks):
    total_squares = n * n
    safe_squares = 0
    unsafe_squares = set()
    for rook in rooks:
        (row, column) = rook
        for i in range(n):
            unsafe_squares.add((row, i))
            unsafe_squares.add((i, column))
    safe_squares = total_squares - len(unsafe_squares)

    return safe_squares


# Words with given shape


def words_with_given_shape(words, shape):
    results = []
    for word in words:
        if len(shape) + 1 == len(word):
            temp_shape = []
            for i in range(0, len(word) - 1):
                if word[i] == word[i + 1]:
                    temp_shape.append(0)
                elif word[i + 1] > word[i]:
                    temp_shape.append(1)
                elif word[i + 1] < word[i]:
                    temp_shape.append(-1)
            if temp_shape == shape:
                results.append(word)
    return results


# Chirality

# def is_left_handed(pips):
#     opposite_dies = {1:6, 2:5, 3:4, 4:3, 5:2, 6:1}
#     perm = permutations([1,2,3])

#     for val in list(perm):
#         print(val)

#     return

# print(is_left_handed((1, 2, 3)))

# The card that wins the trick


def winning_card(cards, trump=None):
    ranks = {
        "two": 2,
        "three": 3,
        "four": 4,
        "five": 5,
        "six": 6,
        "seven": 7,
        "eight": 8,
        "nine": 9,
        "ten": 10,
        "jack": 11,
        "queen": 12,
        "king": 13,
        "ace": 14,
        "none": -1,
    }

    if trump != None:
        if [item for item in cards if item[1] == trump]:
            first_suit = trump
            max_rank = "none"
        else:
            trump = None

    if trump == None:
        first_suit = cards[0][1]
        max_rank = cards[0][0]

    winning_cards = ()
    for r, s in cards:
        if first_suit == s and ranks[r] > ranks[max_rank]:
            max_rank = r
    winning_cards = (max_rank, first_suit)

    return winning_cards


# Do you reach many, do you reach one?
# Sevens rule, zeros drool
# Fulcrum


def can_balance(items):
    s = 0
    for pos in range(len(items)):
        for j, item in enumerate(items):
            s += item * (j - pos)
        if s == 0:
            return pos
        else:
            s = 0
    return -1


# Fail while daring greatly

""" def josephus(n, k):
    alive_men = list(range(1, n+1))
    k = k - 1 # pop automatically skips the dead guy
    idx = k
    while len(alive_men) > 1:
        print(alive_men.pop(idx)) # kill prisoner at idx
        idx = (idx + k) % len(alive_men)
    print('survivor: ', alive_men[0]) """

# return results
# print(josephus(4, 2))
# print()
# All your fractions are belong to base
# Count the balls off the brass monkey


def pyramid_blocks(n, m, h):
    result = (
        Fraction(1, 6)
        * h
        * (3 * h * (m + n - 1) + (2 * h) ** 2 + m(6 * n - 3) - 3 * n + 1)
    )
    return result


# print(pyramid_blocks(2, 3, 10))
# print()

# Count growlers


def count_growlers(animals):
    count = 0
    sign = 1
    for i in range(len(animals)):
        dog_count = 0
        cat_count = 0
        if animals[i] == "cat" or animals[i] == "dog":
            sign = -1
        elif animals[i] == "tac" or animals[i] == "god":
            sign = 1

        if sign == -1:
            for j in range(i - 1, -1, -1):
                if animals[j] == "dog" or animals[j] == "god":
                    dog_count += 1
                elif animals[j] == "cat" or animals[j] == "tac":
                    cat_count += 1
        elif sign == 1:
            for j in range(i + 1, len(animals)):
                if animals[j] == "dog" or animals[j] == "god":
                    dog_count += 1
                elif animals[j] == "cat" or animals[j] == "tac":
                    cat_count += 1
        if dog_count > cat_count:
            count += 1

    return count


# Bulgarian solitaire
# Scylla or Charybdis?
# Longest arithmetic progression
# Best one out of three


def triplets(list_to_split, k):
    for i in range(0, len(list_to_split), k):
        yield list_to_split[i : i + k]


def tukeys_ninthers(items):
    items_split = list(triplets(items, 3))

    result = []
    for item in items_split:
        result.append(statistics.median(item))

    if len(result) > 1:
        result = tukeys_ninthers(result)

    if isinstance(result, list):
        result = result[0]
    return result


# Collecting numbers
# Between the soft and the NP-hard place
# Count Troikanoff, I presume

""" def count_troikas(items):
    result = 0

    items_count = {}
    for i in range(len(items)):
        items_count.setdefault(items[i], [])
        items_count[items[i]].append(i)
    
    for key, value in items_count.items():
        for i, j in itertools.combinations(value, 2):
            print(i,j)
            #k = j + (j - i)
        #if items[k] == items[i]:
        #    result += 1


    return result """

# print(count_troikas([42, 17, 42, 42, 42, 99, 42]))
# print(count_troikas([5, 8, 5, 5]))
# print()

# Crack the crag


def crag_score(dice):
    low_straight = [1, 2, 3]
    high_straight = [4, 5, 6]
    odd_straight = [1, 3, 5]
    even_straight = [2, 4, 6]
    sums = []
    if (dice[0] == dice[1] or dice[0] == dice[2] or dice[1] == dice[2]) and sum(
        dice
    ) == 13:
        return 50
    elif sum(dice) == 13:
        return 26
    elif dice[0] == dice[1] == dice[2]:
        return 25
    elif all(x in dice for x in low_straight):
        return 20
    elif all(x in dice for x in high_straight):
        return 20
    elif all(x in dice for x in odd_straight):
        return 20
    elif all(x in dice for x in even_straight):
        return 20
    else:
        sums.append(sum(d for d in dice if d == 6))
        sums.append(sum(d for d in dice if d == 5))
        sums.append(sum(d for d in dice if d == 4))
        sums.append(sum(d for d in dice if d == 3))
        sums.append(sum(d for d in dice if d == 2))
        sums.append(sum(d for d in dice if d == 1))
        return max(sums)


# Three summers ago
# Sum of two squares
# Carry on Pythonista


def count_carries(a, b):
    count = 0
    carry = 0
    while a != 0 or b != 0:
        addition = a % 10 + b % 10 + carry
        if addition >= 10:
            carry = 1
            count += 1
        else:
            carry = 0

        a = a // 10
        b = b // 10

    return count


# As below, so above
# Expand positive integer intervals


def expand_intervals(intervals):
    if intervals == "":
        return []
    intervals_splited = intervals.split(",")
    result = []
    for interval in intervals_splited:
        ranges = interval.split("-")
        for i in range(int(ranges[0]), int(ranges[-1]) + 1):
            result.append(i)
    return result


# Collapse positive integer intervals


def collapse_intervals(items):
    if len(items) == 0:
        return ""

    if len(items) == 1:
        return str(items[0])

    intervals = ""
    min_num = items[0]
    max_num = -1

    for i in range(0, len(items) - 1):
        if items[i] + 1 != items[i + 1]:
            max_num = items[i]
            if min_num != max_num:
                interval = "-".join([str(min_num), str(max_num)])
            else:
                interval = str(min_num)
            min_num = items[i + 1]
            intervals = ",".join([intervals, interval])
        else:
            max_num = items[i]

    max_num = items[-1]
    if min_num != max_num:
        interval = "-".join([str(min_num), str(max_num)])
    else:
        interval = str(min_num)
    intervals = ",".join([intervals, interval])

    return intervals[1:]


# Prominently featured
# Like a kid in a candy store, except without money
# Dibs to dubs


def duplicate_digit_bonus(n):
    if len(str(n)) == 1:
        return 0
    sum = 0
    digits = [int(d) for d in str(n)]
    blocks = []
    k = 1
    for i in range(len(digits) - 1):
        if digits[i] == digits[i + 1]:
            k += 1
        else:
            blocks.append(k)
            k = 1

    blocks.append(k)

    if len(blocks) == 0:
        return 0
    if len(blocks) >= 1:
        if blocks[-1] > 1:
            sum += (10 ** (blocks[-1] - 2)) * 2
            blocks.remove(blocks[-1])
    for b in blocks:
        if b > 1:
            sum += 10 ** (b - 2)

    return sum


# Nearest smaller element


# Interesting, intersecting
# So shall you sow
# That's enough of you!


def remove_after_kth(items, k=1):
    results = []
    items_count = {}
    for item in items:
        items_count.setdefault(item, 0)
        items_count[item] += 1
        if items_count[item] <= k:
            results.append(item)
    return results


# Brussel's choice
# Cornered cases
# McCulloch's second machine
# That's enough for you!


def first_preceded_by_smaller(items, k=1):
    items_length = len(items)
    count = 0
    result = 0
    for i in range(0, items_length):
        items_i = items[i]
        for j in range(i - 1, -1, -1):
            if count == k:
                result = items[i]
                return result
            if items[j] < items_i:
                count += 1
        if count == k:
            result = items[i]
            return result
        count = 0
    else:
        if count == 0:
            result = None
    return result


# Crab bucket list
# What do you hear, what do you say?


def count_and_say(digits):
    digits_count = {}
    list_digits = []
    previous_digit = digits[0]

    for digit in digits:
        if previous_digit != digit:
            list_digits.append(digits_count)
            digits_count = {}

        digits_count[digit] = digits_count.get(digit, 0) + 1
        previous_digit = digit

    list_digits.append(digits_count)
    result = ""
    for digits_count_dict in list_digits:
        for k, v in digits_count_dict.items():
            result += str(v) + k

    return result


# Bishops on a binge
# Dem’s some mighty tall words, pardner
# Up for the count
# Revorse the vewels


def reverse_vowels(text):
    vowels = list("aeiouAEIOU")

    vowels_in_text = []

    for t in text:
        if t in vowels:
            vowels_in_text.append(t)

    result = ""

    for t in text:
        if t in vowels:
            v = vowels_in_text.pop(-1)
            if t.isupper():
                v = v.upper()
            else:
                v = v.lower()
            result += v
        else:
            result += t

    return result


# Everybody on the floor, come do the Scrooge Shuffle
# Rational lines of action
# Verbos regulares
# Hippity hoppity, abolish loopity
# In space, no one can hear you bounce
# Nearest polygonal number
# Don’t worry, we will fix it in the post
# Fractran interpreter
# Permutation cycles
# Whoever must play, cannot play
# ztalloc ecneuqes
# The solution solution
# Reverse ascending sublists


def reverse_ascending_sublists(items):
    result = []
    sub_list = []
    max_item = items[0]
    for item in items:
        if item < max_item:
            sub_list.reverse()
            result.append(sub_list)
            sub_list = []
        max_item = item
        sub_list.append(item)
    sub_list.reverse()
    result.append(sub_list)
    flat_list = [item for sublist in result for item in sublist]
    return flat_list


# Brangelin-o-matic for the people
# Line with most points
# Om nom nom
# Autocorrect for sausage fingers


# Uambcsrlne the wrod


def unscramble(words, word):
    first_letter = word[:1]
    last_letter = word[-1:]
    middle_letters = word[1:-1]
    sorted_word = sorted(middle_letters)
    length_word = len(word)
    result = [
        w
        for w in words
        if len(w) == length_word
        and w[:1] == first_letter
        and w[-1:] == last_letter
        and sorted(w[1:-1]) == sorted_word
    ]
    result = sorted(result)
    return result


# Substitution words


def substitution_words(pattern, words):
    result = []

    subbed_pattern = dict.fromkeys(pattern)
    subbed_pattern.update((k, i) for i, k in enumerate(subbed_pattern))

    pattern_transformed = "".join(
        str(subbed_pattern[l]) for l in pattern if l in subbed_pattern
    )

    for w in words:
        if len(w) == len(pattern):
            subbed_w = dict.fromkeys(w)
            subbed_w.update((k, i) for i, k in enumerate(subbed_w))

            w_transformed = "".join(str(subbed_w[l]) for l in w if l in subbed_w)

            if pattern_transformed == w_transformed:
                result.append(w)

    return result


# Manhattan skyline
# Count overlapping disks
# Ordinary cardinals
# Count divisibles in range


# Bridge hand shape
# Milton Work point count
# Never the twain shall meet
# Bridge hand shorthand form
# Points, schmoints
# Bulls and cows
# Frequency sort
# Calling all units, B-and-E in progress
# Lunatic multiplication
# Distribution of abstract bridge hand shapes
# Fibonacci sum
# Wythoff array
# Rooks with friends
# Possible words in Hangman
# All branches lead to Rome
# Be there or be square
# Flip of time
# Bulgarian cycle
# Staircase
# Square it out amongst yourselves
# Sum of distinct cubes
# Count maximal layers
# Maximum checkers capture
# Collatzy distance
# Van Eck sequence
# Tips and trips
# Balanced ternary
# Lords of Midnight
# Optimal crag score
# Painted into a corner
# Go for the Grand: Infinite Fibonacci word
# Bonus problem 110: Reverse the Rule 110
# Bonus problem 111: Aye, eye, I
# Bonus problem 112: Count domino tilings
# Bonus problem 113: Invaders must die
# Bonus problem 114: Stepping stones
# Bonus problem 115: Ex iudiciis, lux
# Bonus problem 116: Flatland golf
# Bonus problem 117: TextmirrororrimtxeT 126
