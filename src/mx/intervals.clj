(ns mx.intervals)

;http://en.wikipedia.org/wiki/Interval_(music)

;Minor, Major, or Perfect

(def 
  ^{:name "p1",
    :user/comment "perfect unison",
    :doc "In music, the word unison can be applied in more than one way.
    In general terms, it may refer to two notes sounding the same pitch,
    often but not always at the same time; 
    or to the same musical voice being sounded by several voices or instruments together,
    either at the same pitch or at a distance of one or more octaves;
    or to rhythmic patterns which are homorhythmic."}
  _p1 0)

(def 
  ^{:name "m2",
     :user/comment "minor second",
     :doc "In Western music theory, a major second (whole tone) is a second spanning two semitones ( Play (help·info)).
     A second is a musical interval encompassing two adjacent staff positions (see Interval number for more details).
     For example, the interval from C to D is a major second, as the note D lies two semitones above C,
     and the two notes are notated on adjacent staff positions. Diminished,
     minor and augmented seconds are notated on adjacent staff positions as well,
     but consist of a different number of semitones (zero, one, and three)."}
_m2 1)

(def 
  ^{:name "M2",
    :user/comment "major second",
    :doc "IIn Western music theory, a major second (whole tone) is a second spanning two semitones ( Play (help·info)).
     A second is a musical interval encompassing two adjacent staff positions (see Interval number for more details).
     For example, the interval from C to D is a major second, as the note D lies two semitones above C,
     and the two notes are notated on adjacent staff positions. Diminished,
     minor and augmented seconds are notated on adjacent staff positions as well,
     but consist of a different number of semitones (zero, one, and three)."}
_M2 2)

(def
  ^{:name "m3",
    :user/comment "minor third",
    :doc "In the music theory of Western culture, a minor third is a musical interval that encompasses three half steps,
     or semitones. Staff notation represents the minor third as encompassing three staff positions (see: interval number).
     The minor third is one of two commonly occurring thirds. It is called minor because it is the smaller of the two:
     the major third spans an additional semitone. For example, the interval from A to C is a minor third, as the note C lies three semitones above A,
     and (coincidentally) there are three staff positions from A to C. Diminished and augmented thirds span the same number of staff positions,
     but consist of a different number of semitones (two and five). The minor third is a skip melodically."}
_m3 3)

(def
  ^{:name "major third",
    :user/comment "major third",
    :doc "In classical music from Western culture, a major third is a musical interval that encompasses four semitones."}
_M3 4)

(def
  ^{:name "P4",
    :user/comment "perfect fourth",
    :doc "IIn classical music from Western culture, a fourth is a musical interval encompassing four staff positions 
     (see Interval number for more details), and the perfect fourth ( Play (help·info)) is a fourth spanning five semitones.
     For example, the ascending interval from C to the next F is a perfect fourth, as the note F lies five semitones above C,
     and there are four staff positions from C to F. Diminished and augmented fourths span the same number of staff positions,
     but consist of a different number of semitones (four and six)."}
_P4 5)

(def 
  ^{:name "P5",
    :user/comment "perfect fifth",
    :doc "In classical music from Western culture, a fifth is a musical interval encompassing five staff positions
     (see Interval number for more details), and the perfect fifth (often abbreviated P5) is a fifth spanning seven semitones, 
     or in meantone, four diatonic semitones and three chromatic semitones. For example, 
     the interval from C to G is a perfect fifth, as the note G lies seven semitones above C,
     and there are five staff positions from C to G. Diminished and augmented fifths span the same number of staff positions,
     but consist of a different number of semitones (six and eight, respectively)."}
_P5 7)

(def
  ^{:name "m6",
    :user/comment "minor sixth",
    :doc "In classical music from Western culture, a fifth is a musical interval encompassing five staff positions
     (see Interval number for more details), and the perfect fifth (often abbreviated P5) is a fifth spanning seven semitones, 
     or in meantone, four diatonic semitones and three chromatic semitones. For example, 
     the interval from C to G is a perfect fifth, as the note G lies seven semitones above C,
     and there are five staff positions from C to G. Diminished and augmented fifths span the same number of staff positions,
     but consist of a different number of semitones (six and eight, respectively)."}
_m6 8)

(def
  ^{:name "M6",
    :user/comment "mayor sixth",
    :doc "In classical music from Western culture, a fifth is a musical interval encompassing five staff positions
     (see Interval number for more details), and the perfect fifth (often abbreviated P5) is a fifth spanning seven semitones, 
     or in meantone, four diatonic semitones and three chromatic semitones. For example, 
     the interval from C to G is a perfect fifth, as the note G lies seven semitones above C,
     and there are five staff positions from C to G. Diminished and augmented fifths span the same number of staff positions,
     but consist of a different number of semitones (six and eight, respectively)."}
_M6 9)

(def
    ^{:name "m7",
    :user/comment "minor seventh",
    :doc "In classical music from Western culture, a seventh is a musical interval encompassing seven staff positions (see Interval number for more details),
     and the minor seventh is one of two commonly occurring sevenths. It is qualified as minor because it is the smaller of the two: the minor seventh spans ten semitones,
     the major seventh eleven. For example, the interval from A to G is a minor seventh, as the note G lies ten semitones above A,
     and there are seven staff positions from A to G. Diminished and augmented sevenths span the same number of staff positions,
     but consist of a different number of semitones (nine and twelve)."}
_m7 10)

(def
  ^{:name "M7",
    :user/comment "major seventh",
    :doc "In classical music from Western culture, a seventh is a musical interval encompassing seven staff positions (see Interval number for more details),
     and the major seventh is one of two commonly occurring sevenths. It is qualified as major because it is the larger of the two. The major seventh spans eleven semitones,
     its smaller counterpart being the minor seventh, spanning ten semitones. For example, the interval from C to B is a major seventh, as the note B lies eleven semitones above C, 
     and there are seven staff positions from C to B. Diminished and augmented sevenths span the same number of staff positions, but consist of a different number of semitones (nine and twelve)."}
_M7 11)

(def
  ^{:name "P8",
    :user/comment "perfect octave",
    :doc "In music, an octave (Latin octavus: eighth) or perfect octave is the interval between one musical pitch and another with half or double its frequency.
     The octave relationship is a natural phenomenon that has been referred to as the \"basic miracle of music\", 
     the use of which is \"common in most musical systems\".It may be derived from the harmonic series as the interval between the first and second harmonics."}
_P8 12)

;Augmented or Diminished

(def 
   ^{:name "d2",
    :user/comment "diminished second",
    :doc "In modern Western tonal music theory a diminished second is the interval between notes on two adjacent staff positions, or having adjacent note letters, 
     whose alterations cause them, in ordinary equal temperament, to have no pitch difference, such as B and C♭ or B♯ and C.
     The two notes may more often be described as Enharmonic equivalents."}
_d2 1)

(def 
   ^{:name "A1",
    :user/comment "augmented unison",
    :doc "A semitone, also called a half step or a half tone,[1] is the smallest musical interval commonly used in Western tonal music,[2] and it is considered the most dissonant[3] when sounded harmonically.
     It is defined as the interval between two adjacent notes in a 12-tone scale (e.g. from C to C♯). This implies that its size is exactly or approximately equal to 100 cents,
     a twelfth of an octave."}
_A1 1)

(def 
   ^{:name "d3",
    :user/comment "diminished third",
    :doc "In classical music from Western culture, a diminished third ( Play (help·info)) is the musical interval produced by narrowing a minor third by a chromatic semitone.
     For instance, the interval from A to C is a minor third, three semitones wide, and both the intervals from A♯ to C, and from A to C♭ are diminished thirds,
     two semitones wide. Being diminished, it is considered a dissonant interval."}
_d3 2)

(def 
  ^{:name "A2",
    :user/comment "augmented second",
    :doc "In classical music from Western culture, an augmented second is an interval produced by widening a major second by a chromatic semitone.[1][3] For instance,
     the interval from C to D is a major second, two semitones wide, and both the intervals from C♭ to D, and from C to D♯ are augmented seconds, spanning three semitones."}
_A2 3)

(def
   ^{:name "d4",
    :user/comment "diminished fourth",
    :doc "In classical music from Western culture, a diminished fourth ( Play (help·info)) is an interval produced by narrowing a perfect fourth by a chromatic semitone.
     For example, the interval from C to F is a perfect fourth, five semitones wide, and both the intervals from C♯ to F, and from C to F♭ are diminished fourths,
     spanning four semitones. Being diminished, it is considered a dissonant interval."}
_d4 4)

(def
  ^{:name "A3",
    :user/comment "augmented third",
    :doc "In classical music from Western culture, an augmented third ( Play (help·info)) is an interval of five semitones. It may be produced by widening a major third by a chromatic semitone.
     For instance, the interval from C to E is a major third, four semitones wide, and both the intervals from C♭ to E, and from C to E♯ are augmented thirds, spanning five semitones. 
     Being augmented, it is considered a dissonant interval."}
_A3 5)

(def 
  ^{:name "d5",
    :user/comment "diminished fifth",
    :doc "In music theory, the tritone is strictly defined as a musical interval composed of three adjacent whole tones.
     For instance, the interval from F up to the B above it (in short, F–B) is a tritone as it can be decomposed into the three adjacent whole tones F–G, G–A, and A–B.
     According to this definition, within a diatonic scale there is only one tritone for each octave. For instance,
     the above-mentioned interval F–B is the only tritone which can be formed using the notes of the C-major scale.
     A tritone is also commonly defined as an interval spanning six semitones. According to this definition, a diatonic scale contains two tritones for each octave.
     For instance, the above mentioned C-major scale contains the ascending tritones F–B (from F to the B above it, also called augmented fourth) and B-F (from B up to the F above it,
     also called diminished fifth or semidiapente). To avoid the ambiguity created by the existence of two different definitions, a tritone which meets the strict definition,
     such as F–B, is sometimes called a proper tritone."}
_d5 6)

(def
  ^{:name "A4",
    :user/comment "augmented fourth",
    :doc "In music theory, the tritone is strictly defined as a musical interval composed of three adjacent whole tones.
     For instance, the interval from F up to the B above it (in short, F–B) is a tritone as it can be decomposed into the three adjacent whole tones F–G, G–A, and A–B.
     According to this definition, within a diatonic scale there is only one tritone for each octave. For instance,
     the above-mentioned interval F–B is the only tritone which can be formed using the notes of the C-major scale.
     A tritone is also commonly defined as an interval spanning six semitones. According to this definition, a diatonic scale contains two tritones for each octave.
     For instance, the above mentioned C-major scale contains the ascending tritones F–B (from F to the B above it, also called augmented fourth) and B-F (from B up to the F above it,
     also called diminished fifth or semidiapente). To avoid the ambiguity created by the existence of two different definitions, a tritone which meets the strict definition,
     such as F–B, is sometimes called a proper tritone."}
_A4 6)

(def 
  ^{:name "d6",
    :user/comment "diminished sixth",
    :doc "In classical music from Western culture, a diminished sixth ( Play (help·info)) is an interval produced by narrowing a minor sixth by a chromatic semitone.[
     For example, the interval from A to F is a minor sixth, eight semitones wide, and both the intervals from A♯ to F, and from A to F♭ are diminished sixths,
     spanning seven semitones. Being diminished, it is considered a dissonant interval."}
_d6 7)

(def 
  ^{:name "A5",
    :user/comment "Augmented fifth",
    :doc "In classical music from Western culture, an augmented fifth ( Play (help·info)) is an interval produced by widening a perfect fifth by a chromatic semitone.
     For instance, the interval from C to G is a perfect fifth, seven semitones wide, and both the intervals from C♭ to G, and from C to G♯ are augmented fifths,
     spanning eight semitones. Being augmented, it is considered a dissonant interval."}
_A5 8)

(def
  ^{:name "d7",
    :user/comment "diminished seventh",
    :doc "In classical music from Western culture, a diminished seventh ( play (help·info)) is an interval produced by narrowing a minor seventh by a chromatic semitone.[1][4] For instance,
     the interval from A to G is a minor seventh, ten semitones wide, and both the intervals from A♯ to G, and from A to G♭ are diminished sevenths, spanning nine semitones. Being diminished,
     it is considered a dissonant interval."}
_d7 9)

(def 
  ^{:name "A6",
    :user/comment "augmented seventh",
    :doc "In classical music from Western culture, an augmented sixth ( Play (help·info)) is an interval produced by widening a major sixth by a chromatic semitone.[1][3] For instance,
     the interval from C to A is a major sixth, nine semitones wide, and both the intervals from C♭ to A, and from C to A♯ are augmented sixths, spanning ten semitones. 
     Being augmented, it is considered a dissonant interval.[4]"}
_A6 10)

(def  
  ^{:name "d8",
    :user/comment "diminished octave",
    :doc "In classical music from Western culture, a diminished octave ( Play (help·info)) is an interval produced by narrowing a perfect octave by a chromatic semitone.[1] As such,
     the two notes are denoted by the same letter but have different accidentals. For instance, the interval from C4 to C5 is a perfect octave, twelve semitones wide, 
     and both the intervals from C♯4 to C5, and from C4 to C♭5 are diminished octaves, spanning eleven semitones. Being diminished, it is considered a dissonant interval.[2]"}
_d8 11)

(def 
  ^{:name "A7",
    :user/comment "augmented seventh",
    :doc "In classical music from Western culture, an augmented seventh is an interval produced by widening a major seventh by a chromatic semitone. For instance, 
     the interval from C to B is a major seventh, eleven semitones wide, and both the intervals from C♭ to B, and from C to B♯ are augmented sevenths,
     spanning twelve semitones. Being augmented, it is considered a dissonant interval."}
_A7 12)
